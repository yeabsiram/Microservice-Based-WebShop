package App.DTO;

import App.domain.Order;

public class OrderAdapter {

    public static Order fromDTO(OrderDTO dto){
        Order order = new Order(dto.getOrderNumber(), dto.getDate(), dto.getTotalPrice(), dto.getCustomerNumber(), dto.getCustomerName(), dto.getCustomerEmail());
        order.setOrderLineList(OrderLineAdapter.fromDto(dto.getOrderLineList()));
        order.setPaymentDTO(dto.getPaymentDTO());
        return order;
    }

    public static OrderDTO toDTO(Order order){

        OrderDTO orderDTO = new OrderDTO(order.getOrderNumber(), order.getDate(), order.getTotalPrice(), order.getCustomerNumber(), order.getCustomerName(), order.getCustomerEmail()) ;
        orderDTO.setPaymentDTO(order.getPaymentDTO());
        orderDTO.setOrderLineList(OrderLineAdapter.toDto(order.getOrderLineList()));
        return orderDTO;
    }
}
