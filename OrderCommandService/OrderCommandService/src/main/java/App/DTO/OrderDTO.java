package App.DTO;

import java.util.Date;
import java.util.List;


public class OrderDTO {


    private String orderNumber;

    private Date date;

    private double totalPrice;

    private String customerNumber;

    private String customerName;

    private PaymentDTO paymentDTO;

    private String customerEmail;


    private List<OrderLineDTO> orderLineList;

    public OrderDTO(String orderNumber, Date date, double totalPrice, String customerNumber, String customerName, String customerEmail) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public PaymentDTO getPaymentDTO() {
        return paymentDTO;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public List<OrderLineDTO> getOrderLineList() {
        return orderLineList;
    }

    public void addOrderLine(OrderLineDTO orderLine)
    {
        this.orderLineList.add(orderLine);
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderNumber='" + orderNumber + '\'' +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                ", customerNumber='" + customerNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", paymentDTO=" + paymentDTO +
                ", customerEmail='" + customerEmail + '\'' +
                ", orderLineList=" + orderLineList +
                '}';
    }
}
