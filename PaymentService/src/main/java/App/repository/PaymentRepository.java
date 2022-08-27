package App.repository;

import App.domain.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface PaymentRepository extends MongoRepository<Payment,String > {
    Optional<Payment>  findPaymentByPaymentNumber(String paymentNumber);
}

