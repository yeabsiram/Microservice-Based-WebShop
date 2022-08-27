package App.service;

import App.DTO.*;

public interface OrderService {
    OrderDTO get(String orderNumber);

    void add(OrderDTO orderDTO);

    void delete(String orderNumber);

    void update(String orderNumber, OrderDTO orderDTO);

    void handle(ProductChangeDTO productChangeDTO);

    void handle(PaymentChangeDTO paymentChangeDTO);

    void handle(CustomerChangeDTO customerChangeDTO);

    void handle(OrderChangeDTO orderChangeDTO);
}
