package ProductService.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String productNumber;
    private String name;
    private double price;

    private String supplierName;

    private String supplierPhone;


    public Product(){}

    public Product(String productNumber, String name, double price, String supplierName, String supplierPhone) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    public void setSupplier(String supplier) {
        this.supplierName = supplier;
    }

    public void setSupplierPhone(String supplierPhone) {
        this.supplierPhone = supplierPhone;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productNumber + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supplierName='" + supplierName + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                '}';
    }
}
