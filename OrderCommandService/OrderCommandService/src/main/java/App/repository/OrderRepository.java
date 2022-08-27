package App.repository;

import App.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order,String > {
    @Query("{'OrderLineList':{$elemMatch:  {'productDTO.productNumber': :#{#productNumber}}}}")
    public List<Order> findOrderByProductNumber(@Param("productNumber") String productNumber);

    @Query("{'PaymentDTO.paymentNumber': :#{#paymentNumber}}")
    public Order findOrderByPaymentNumber(@Param("paymentNumber") String paymentNumber);

    public List<Order> findOrderByCustomerNumber(String customerNumber);

}

