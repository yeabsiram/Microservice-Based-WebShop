package App.DTO;

import App.service.PaymentDTO;

public class PaymentChangeDTO {

    private String change;
    private PaymentDTO payment;

    public PaymentChangeDTO() {
    }

    public PaymentChangeDTO(String change, PaymentDTO paymentDTO) {
        this.change = change;
        this.payment = paymentDTO;
    }

    public String getChange() {
        return change;
    }

    public PaymentDTO getPayment() {
        return payment;
    }

    @Override
    public String toString() {
        return "PaymentChangeDTO{" +
                "change='" + change + '\'' +
                ", payment=" + payment +
                '}';
    }
}
