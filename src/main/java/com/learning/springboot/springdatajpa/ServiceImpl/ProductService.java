package com.learning.springboot.springdatajpa.ServiceImpl;

import com.learning.springboot.springdatajpa.Entity.ProductEntity;

public interface ProductService {
	ProductEntity saveProduct(ProductEntity product);

	ProductEntity getProductById(Long id);

	void deleteProduct(Long id);

	ProductEntity updateProduct(Long id, ProductEntity updatedProduct);
}
