package App.service;

public interface PaymentService {
    void add(PaymentDTO paymentDTO);
    void delete(String paymentNumber);
    void update(String paymentNumber, PaymentDTO paymentDTO);

    PaymentDTO get(String paymentNumber);
}
