package CustomerService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Customer {

   // customernumber, name, phone, email, street, city, zip

    @Id
    private String customerNumber;

    private String name;

    private String phone;

    private String email;

    private Address address;

    public Customer(String customerNumber, String name, String phone, String email, Address address) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer() {
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

    public Address getAddress() {
        return address;
    }



    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber='" + customerNumber + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
