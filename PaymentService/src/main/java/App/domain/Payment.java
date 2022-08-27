package App.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Payment {
    @Id
    private String paymentNumber;
    private Date date;

    private double amount;

    private String orderNumber;

    private String customerNumber;

    public Payment(String paymentNumber, Date date, double amount, String orderNumber, String customerNumber) {
        this.paymentNumber = paymentNumber;
        this.date = date;
        this.amount = amount;
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
    }

    public Payment() {
    }

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentNumber='" + paymentNumber + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                ", orderNumber='" + orderNumber + '\'' +
                ", customerNumber='" + customerNumber + '\'' +
                '}';
    }
}
