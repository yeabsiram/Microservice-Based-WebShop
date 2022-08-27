package ProductService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ProductService.domain.Product;
import ProductService.integration.KafkaSender;
import ProductService.repository.ProductRepository;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private KafkaSender kafkaSender;

    @Override
    public void add(ProductDTO productDTO) {
         Product product = ProductAdapter.fromDTO(productDTO);
        System.out.println("DTO:"+productDTO);
        System.out.println("product:"+product);
        productRepository.save(product);
        kafkaSender.sendMessage(new ProductChangeEventDTO("add", productDTO));
    }

    @Override
    public void delete(String productId) {
        productRepository.deleteById(productId);
        kafkaSender.sendMessage(new ProductChangeEventDTO("delete", new ProductDTO(productId, "", 0.0, "","")));

    }

    @Override
    public void update(String productNumber, ProductDTO productDTO) {
        Optional<Product> optionalProduct = productRepository.findProductByProductNumber(productNumber);
        if(optionalProduct.isPresent()){
            Product product = ProductAdapter.fromDTO(productDTO);
            productRepository.save(product);
            kafkaSender.sendMessage(new ProductChangeEventDTO("update", productDTO));
        }
    }

    @Override
    public ProductDTO get(String productNumber) {
        Optional<Product> optionalProduct = productRepository.findById(productNumber);

        if (optionalProduct.isPresent()){
            ProductDTO productDTO = ProductAdapter.toDTO(optionalProduct.get());
            return productDTO;
        }else {
            return null;
        }
    }
}
