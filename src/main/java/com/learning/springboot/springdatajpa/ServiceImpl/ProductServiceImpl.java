package com.learning.springboot.springdatajpa.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.springdatajpa.Entity.ProductEntity;
import com.learning.springboot.springdatajpa.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductEntity saveProduct(ProductEntity product) {
		return productRepository.save(product);
	}

	@Override
	public ProductEntity getProductById(Long id) {
		return productRepository.findById(id).orElseThrow(
				() -> new RuntimeException("Product not found " + id));
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public ProductEntity updateProduct(Long id, ProductEntity updatedProduct) {
		return productRepository.findById(id).map(existing -> {
			existing.setName(updatedProduct.getName());
			existing.setDescription(updatedProduct.getDescription());
			existing.setPrice(updatedProduct.getPrice());
			existing.setStock(updatedProduct.getStock());
			return productRepository.save(existing);
		}).orElseThrow(() -> new RuntimeException("Product not found " + id));
	}
}