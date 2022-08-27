package App.DTO;

public class PaymentChangeDTO {

    private String change;
    private PaymentDTO payment;

    public PaymentChangeDTO() {
    }

    public PaymentChangeDTO(String change, PaymentDTO paymentDTO) {
        this.change = change;
        this.payment = paymentDTO;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
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
