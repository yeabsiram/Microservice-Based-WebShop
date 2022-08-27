package App.service;

import App.DTO.*;
import App.domain.Order;
import App.domain.OrderLine;
import App.integration.KafkaSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import App.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    KafkaSender kafkaSender;

    @Override
    public void add(OrderDTO orderDTO) {
        Order order = OrderAdapter.fromDTO(orderDTO);
        orderRepository.save(order);
        kafkaSender.send(new OrderChangeDTO("add", orderDTO));

    }

    @Override
    public void delete(String orderNumber) {
        orderRepository.deleteById(orderNumber);
        kafkaSender.send(new OrderChangeDTO("delete", new OrderDTO(orderNumber, null, 0.0,"","","")));
    }

    @Override
    public void update(String orderNumber, OrderDTO orderDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(orderNumber);
        if(optionalOrder.isPresent()){
            Order order = OrderAdapter.fromDTO(orderDTO);
            orderRepository.save(order);
            kafkaSender.send(new OrderChangeDTO("update", orderDTO));
        }
    }
    private void updateProduct(String orderNumber, ProductDTO productDTO) {
        List<Order> orders = orderRepository.findOrderByProductNumber(orderNumber);

        for(Order order: orders)
        {
            for(OrderLine orderLine: order.getOrderLineList())
            {
                if(orderLine.getProduct().getProductNumber().equals(productDTO.getProductNumber()))
                {
                    orderLine.setProduct(productDTO);
                }
            }
        }
        if(orders.size() > 0)
        {
            for(Order order: orders)
            {
                orderRepository.save(order);
            }
        }

    }
    private void updatePayment(String paymentNumber, PaymentDTO paymentDTO)
    {
        Order order = orderRepository.findOrderByPaymentNumber(paymentNumber);
        if(order != null)
        {
            order.setPaymentDTO(paymentDTO);
            orderRepository.save(order);
        }
    }
    private void addPayment(String orderNumber, PaymentDTO paymentDTO)
    {
        Optional<Order> optionalOrder = orderRepository.findById(orderNumber);
        if(optionalOrder.isPresent())
        {
            Order order = optionalOrder.get();
            order.setPaymentDTO(paymentDTO);
            orderRepository.save(order);
        }
    }
    private void updateCustomer(String customerNumber, CustomerChangeDTO customerChangeDTO)
    {
        List<Order> orders = orderRepository.findOrderByCustomerNumber(customerNumber);

        for(Order order : orders)
        {
            order.setCustomerNumber(customerChangeDTO.getCustomer().getCustomerNumber());
            order.setCustomerName(customerChangeDTO.getCustomer().getName());
            order.setCustomerEmail(customerChangeDTO.getCustomer().getEmail());
        }
        if(orders.size() > 0)
        {
            for(Order order: orders)
            {
                orderRepository.save(order);
            }
        }
    }

    @Override
    public void handle(ProductChangeDTO productChangeDTO) {
        if(productChangeDTO.getChange().equals("update"))
        {
            updateProduct(productChangeDTO.getProduct().getProductNumber(), productChangeDTO.getProduct());
        }
    }

    @Override
    public void handle(PaymentChangeDTO paymentChangeDTO) {
        if(paymentChangeDTO.getChange().equals("update"))
        {
            updatePayment(paymentChangeDTO.getPayment().getPaymentNumber(), paymentChangeDTO.getPayment());
        }
        else{
            addPayment(paymentChangeDTO.getPayment().getOrderNumber(), paymentChangeDTO.getPayment());
        }

    }

    @Override
    public void handle(CustomerChangeDTO customerChangeDTO) {
        updateCustomer(customerChangeDTO.getCustomer().getCustomerNumber(), customerChangeDTO);
    }


}
