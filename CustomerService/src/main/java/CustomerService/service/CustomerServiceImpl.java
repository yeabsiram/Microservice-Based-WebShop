package CustomerService.service;

import CustomerService.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import CustomerService.integration.KafkaSender;
import CustomerService.repository.CustomerRepository;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private KafkaSender kafkaSender;

    @Override
    public void add(CustomerDTO customerDTO) {
        Customer customer = CustomerAdapter.fromDTO(customerDTO);
        System.out.println(customerDTO);
        customerRepository.save(customer);

    }

    @Override
    public void delete(String customerId) {
        customerRepository.deleteById(customerId);

    }

    @Override
    public void update(String customerNumber, CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findCustomerByCustomerNumber(customerNumber);
        if(optionalCustomer.isPresent()){
            Customer customer = CustomerAdapter.fromDTO(customerDTO);
            customerRepository.save(customer);
            kafkaSender.sendMessage(new CustomerChangeEventDTO("update", customerDTO));
        }
    }

    @Override
    public CustomerDTO get(String customerNumber) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerNumber);

        if (optionalCustomer.isPresent()){
            CustomerDTO customerDTO = CustomerAdapter.toDTO(optionalCustomer.get());
            return customerDTO;
        }else {
            return null;
        }
    }
}
