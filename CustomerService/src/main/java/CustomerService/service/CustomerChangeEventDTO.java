package CustomerService.service;

public class CustomerChangeEventDTO {

    private String change;
    private CustomerDTO customer;

    public CustomerChangeEventDTO() {
    }

    public CustomerChangeEventDTO(String change, CustomerDTO customer) {
        this.change = change;
        this.customer = customer;
    }

    public String getChange() {
        return change;
    }

    public CustomerDTO getCustomer() {
        return customer;
    }
}
