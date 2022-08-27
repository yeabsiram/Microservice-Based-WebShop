package App.DTO;

public class OrderLineDTO {
    private int quantity;

    private ProductDTO productDTO;


    public OrderLineDTO(int quantity, ProductDTO productDTO) {
        this.quantity = quantity;
        this.productDTO = productDTO;
    }

    public OrderLineDTO() {
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductDTO getProduct() {
        return productDTO;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProduct(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "quantity=" + quantity +
                ", product=" + productDTO +
                '}';
    }
}
