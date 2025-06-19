package com.learning.springboot.springdatajpa;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.learning.springboot.springdatajpa.Entity.ProductEntity;
import com.learning.springboot.springdatajpa.ServiceImpl.ProductService;

@SpringBootApplication
public class SpringdatajpaApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringdatajpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// Save new product
		ProductEntity product = new ProductEntity();
		product.setName("Laptop");
		product.setDescription("Gaming Laptop");
		product.setPrice(new BigDecimal("50000.00"));
		product.setStock(10);

		ProductEntity savedProduct = productService.saveProduct(product);
		System.out.println("Saved Product: " + savedProduct);

		// Get product by ID
		ProductEntity productById = productService.getProductById(savedProduct.getId());
		System.out.println(productById);

		// Update product
		ProductEntity update = new ProductEntity();
		update.setName("Updated Laptop");
		update.setDescription("Updated Gaming Laptop");
		update.setPrice(new BigDecimal("60000.00"));
		update.setStock(5);

		ProductEntity updated = productService.updateProduct(savedProduct.getId(), update);
		System.out.println("Updated Product: " + updated);

		// Delete product
//		productService.deleteProduct(updated.getId());
//		System.out.println("Deleted Product with ID: " + updated.getId());
	}

}
