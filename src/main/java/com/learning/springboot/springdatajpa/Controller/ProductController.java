package com.learning.springboot.springdatajpa.Controller;

import com.learning.springboot.springdatajpa.Entity.ProductEntity;
import com.learning.springboot.springdatajpa.ServiceImpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ProductEntity addProductDetails(@RequestBody ProductEntity product) {

        return productService.saveProduct(product);

    }


}
