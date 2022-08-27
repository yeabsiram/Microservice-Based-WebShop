package App.DTO;

public class ProductChangeDTO {

    private String change;

    private ProductDTO product;

    public ProductChangeDTO(String change, ProductDTO productDTO) {
        this.change = change;
        this.product = productDTO;
    }

    public ProductChangeDTO() {
    }

    public String getChange() {
        return change;
    }

    public ProductDTO getProduct() {
        return product;
    }
}
