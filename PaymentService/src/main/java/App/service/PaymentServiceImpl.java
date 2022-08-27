package App.service;

import App.DTO.PaymentChangeDTO;
import App.domain.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import App.integration.KafkaSender;
import App.repository.PaymentRepository;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private KafkaSender kafkaSender;

    @Override
    public void add(PaymentDTO paymentDTO) {
        Payment payment = PaymentAdapter.fromDTO(paymentDTO);

        paymentRepository.save(payment);

        PaymentChangeDTO paymentChangeDTO = new PaymentChangeDTO("add", paymentDTO);
        System.out.println(paymentChangeDTO + " Service ");
        kafkaSender.sendMessage(paymentChangeDTO);
    }

    @Override
    public void delete(String paymentNumber) {
        paymentRepository.deleteById(paymentNumber);
        kafkaSender.sendMessage(new PaymentChangeDTO("delete", new PaymentDTO(paymentNumber, null, 0.0, "", "")));
    }

    @Override
    public void update(String paymentNumber, PaymentDTO paymentDTO) {
        Optional<Payment> optionalPayment = paymentRepository.findPaymentByPaymentNumber(paymentNumber);
        if(optionalPayment.isPresent()){
            Payment payment = PaymentAdapter.fromDTO(paymentDTO);
            paymentRepository.save(payment);
            kafkaSender.sendMessage(new PaymentChangeDTO("update", paymentDTO));
        }
    }

    @Override
    public PaymentDTO get(String paymentNumber) {
        Optional<Payment> optionalPayment = paymentRepository.findById(paymentNumber);

        if (optionalPayment.isPresent()){
            PaymentDTO paymentDTO = PaymentAdapter.toDTO(optionalPayment.get());
            return paymentDTO;
        }else {
            return null;
        }
    }
}
