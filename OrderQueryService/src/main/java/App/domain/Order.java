package App.domain;

import App.DTO.PaymentDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
public class Order {

    @Id
    private String orderNumber;

    private Date date;

    private double totalPrice;

    private String customerNumber;

    private String customerName;

    private PaymentDTO paymentDTO;

    private String customerEmail;

    private List<OrderLine> orderLineList = new ArrayList<>();

    public Order(String orderNumber, Date date, double totalPrice, String customerNumber, String customerName, String customerEmail) {
        this.orderNumber = orderNumber;
        this.date = date;
        this.totalPrice = totalPrice;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public void addOrderLine(OrderLine orderLine)
    {
        this.orderLineList.add(orderLine);
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

    public List<OrderLine> getOrderLineList() {
        return orderLineList;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setPaymentDTO(PaymentDTO paymentDTO) {
        this.paymentDTO = paymentDTO;
    }

    public void setOrderLineList(List<OrderLine> orderLineList) {
        this.orderLineList = orderLineList;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", date=" + date +
                ", totalPrice=" + totalPrice +
                ", customerNumber='" + customerNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", paymentDTO=" + paymentDTO +
                ", orderLineList=" + orderLineList +
                '}';
    }
}
