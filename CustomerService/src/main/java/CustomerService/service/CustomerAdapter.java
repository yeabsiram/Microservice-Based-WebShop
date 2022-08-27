package CustomerService.service;


import CustomerService.domain.Customer;

public class CustomerAdapter {
    public static Customer fromDTO(CustomerDTO dto){
        Customer customer = new Customer(dto.getCustomerNumber(), dto.getName(), dto.getPhone(), dto.getEmail(), AddressAdapter.fromDTO(dto.getAddress()));
        return customer;
    }

    public static CustomerDTO toDTO(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO(customer.getCustomerNumber(), customer.getName(), customer.getPhone(), customer.getEmail(), AddressAdapter.toDTO(customer.getAddress()));
        return customerDTO;
    }
}
