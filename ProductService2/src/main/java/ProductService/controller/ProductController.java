package ProductService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ProductService.service.ProductDTO;
import ProductService.service.ProductService;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public ResponseEntity<?> add(@RequestBody ProductDTO productDTO){
        productService.add(productDTO);
        return new ResponseEntity<>(productDTO, HttpStatus.OK);
    }

    @PutMapping("/products/{productNumber}")
    public ResponseEntity<?> update(@PathVariable String productNumber,@RequestBody ProductDTO productDTO){
        productService.update(productNumber,productDTO);
        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }

    @DeleteMapping("/products/{productNumber}")
    public ResponseEntity<?> delete(@PathVariable String productNumber){
        productService.delete(productNumber);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    @GetMapping(value = "/products/{productNumber}")
    public ResponseEntity<?> get(@PathVariable String productNumber)
    {
        ResponseEntity responseEntity;
        ProductDTO productDTO = productService.get(productNumber);
        if(productDTO == null)
        {
            responseEntity = new ResponseEntity<>(new CustomError("Product with the number "+ productNumber + " is not found."), HttpStatus.NOT_FOUND);

        }
        else {
            responseEntity = new ResponseEntity<>(productDTO, HttpStatus.OK);
        }
        return responseEntity;
    }
}
