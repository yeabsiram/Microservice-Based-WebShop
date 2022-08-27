package App.domain;

import App.DTO.ProductDTO;

public class OrderLine {

    private int quantity;

    private ProductDTO productDTO;


    public OrderLine(int quantity, ProductDTO productDTO) {
        this.quantity = quantity;
        this.productDTO = productDTO;
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
