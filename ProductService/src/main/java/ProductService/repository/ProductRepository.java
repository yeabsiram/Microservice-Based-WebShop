package ProductService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ProductService.domain.Product;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product,String > {
    Optional<Product> findProductByProductNumber(String s);
}

