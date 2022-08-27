package App.DTO;

public class CustomerChangeDTO {

     private String change;

     private CustomerDTO customer;

     public CustomerChangeDTO(String change, CustomerDTO customerD) {
          this.change = change;
          this.customer = customerD;
     }

     public CustomerChangeDTO() {
     }

     public String getChange() {
          return change;
     }

     public CustomerDTO getCustomer() {
          return customer;
     }

     public void setChange(String change) {
          this.change = change;
     }

     public void setCustomer(CustomerDTO customerD) {
          this.customer = customerD;
     }

     @Override
     public String toString() {
          return "CustomerChangeDTO{" +
                  "change='" + change + '\'' +
                  ", customerD=" + customer +
                  '}';
     }
     //    private String customerNumber;
//    private String customerName;
//    private String customerEmail;
//
//    public CustomerChangeDTO() {
//    }
//
//    public CustomerChangeDTO(String customerNumber, String customerName, String customerEmail ) {
//        this.customerEmail = customerEmail;
//        this.customerName = customerName;
//        this.customerNumber = customerNumber;
//    }
//
//    public String getCustomerNumber() {
//        return customerNumber;
//    }
//
//    public String getCustomerName() {
//        return customerName;
//    }
//
//    public String getCustomerEmail() {
//        return customerEmail;
//    }
//
//    @Override
//    public String toString() {
//        return "CustomerChangeDTO{" +
//                "customerNumber='" + customerNumber + '\'' +
//                ", customerName='" + customerName + '\'' +
//                ", customerEmail='" + customerEmail + '\'' +
//                '}';
//    }
}
