package App.DTO;

public class CustomerDTO {
    private String customerNumber;

    private String name;

    private String phone;

    private String email;

    private AddressDTO address;

    public CustomerDTO(String customerNumber, String name, String phone, String email, AddressDTO address) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public CustomerDTO() {
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public AddressDTO getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerNumber='" + customerNumber + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
