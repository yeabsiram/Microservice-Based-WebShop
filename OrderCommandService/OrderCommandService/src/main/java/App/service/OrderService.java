package App.service;

import App.DTO.CustomerChangeDTO;
import App.DTO.OrderDTO;
import App.DTO.PaymentChangeDTO;
import App.DTO.ProductChangeDTO;

public interface OrderService {
    void add(OrderDTO orderDto);
    void delete(String orderNumber);
    void update(String orderNumber, OrderDTO orderDTO);

    void handle(ProductChangeDTO productChangeDTO);

    void handle(PaymentChangeDTO paymentChangeDTO);

    void handle(CustomerChangeDTO customerChangeDTO);
}
