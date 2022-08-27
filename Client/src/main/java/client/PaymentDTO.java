package client;

import java.util.Date;

public class PaymentDTO {
    private String paymentNumber;


    private Date date;

    private double amount;

    private String orderNumber;

    private String customerNumber;

    public PaymentDTO(String paymentNumber, Date date, double amount, String orderNumber, String customerNumber) {
        this.paymentNumber = paymentNumber;
        this.date = date;
        this.amount = amount;
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
    }

    public PaymentDTO() {
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public Date getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentNumber='" + paymentNumber + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", orderNumber='" + orderNumber + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }
}
