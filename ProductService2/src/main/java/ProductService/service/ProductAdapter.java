package ProductService.service;


import ProductService.domain.Product;

public class ProductAdapter {
    public static Product fromDTO(ProductDTO dto){
        return new Product(dto.getProductNumber(), dto.getName(), dto.getPrice(), dto.getSupplierName(), dto.getSupplierPhone());
    }

    public static ProductDTO toDTO(Product product){
        return new ProductDTO(product.getProductNumber(), product.getName(), product.getPrice(), product.getSupplierName(), product.getSupplierPhone());
    }
}
