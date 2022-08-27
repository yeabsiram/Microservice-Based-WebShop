package App.service;

import App.domain.Payment;

public class PaymentAdapter {

    public static Payment fromDTO(PaymentDTO dto){
        Payment payment = new Payment(dto.getPaymentNumber(), dto.getDate(), dto.getAmount(), dto.getOrderNumber(), dto.getCustomerNumber());
        return payment;
    }

    public static PaymentDTO toDTO(Payment payment){
        PaymentDTO paymentDTO = new PaymentDTO(payment.getPaymentNumber(), payment.getDate(), payment.getAmount(), payment.getOrderNumber(), payment.getCustomerNumber());
        return paymentDTO;
    }
}
