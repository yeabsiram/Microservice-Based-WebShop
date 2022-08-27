package ProductService.service;

public class ProductDTO {
    private String productNumber;
    private String name;
    private double price;

    private String supplierName;

    private String supplierPhone;

    public ProductDTO(){}

    public ProductDTO(String productNumber, String name, double price, String supplierName, String supplierPhone ) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
        this.supplierName = supplierName;
        this.supplierPhone = supplierPhone;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public String getSupplierPhone() {
        return supplierPhone;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productNumber='" + productNumber + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", supplierName='" + supplierName + '\'' +
                ", supplierPhone='" + supplierPhone + '\'' +
                '}';
    }
}
