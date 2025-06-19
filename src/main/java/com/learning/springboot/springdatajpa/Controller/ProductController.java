package com.learning.springboot.springdatajpa.Controller;

import com.learning.springboot.springdatajpa.Entity.ProductEntity;
import com.learning.springboot.springdatajpa.ServiceImpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductEntity addProduct(@RequestBody ProductEntity product) {
        return productService.saveProduct(product);
    }

    @GetMapping
    public ProductEntity getProductDetail(@PathVariable Integer productId) {
        return productService.getProductById(Long.valueOf(productId));
    }

    @DeleteMapping
    public void deleteProductDetail(@PathVariable Integer productId) {
        productService.deleteProduct(Long.valueOf(productId));
    }


}
