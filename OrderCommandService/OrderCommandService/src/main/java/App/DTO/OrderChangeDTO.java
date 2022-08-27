package App.DTO;

public class OrderChangeDTO {

    private String change;

    private  OrderDTO orderDTO;

    public OrderChangeDTO(String change, OrderDTO orderDTO) {
        this.change = change;
        this.orderDTO = orderDTO;
    }

    public String getChange() {
        return change;
    }

    public OrderDTO getOrderDTO() {
        return orderDTO;
    }
}
