package CustomerService.repository;

import CustomerService.domain.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,String > {
    Optional<Customer>  findCustomerByCustomerNumber(String s);
}

