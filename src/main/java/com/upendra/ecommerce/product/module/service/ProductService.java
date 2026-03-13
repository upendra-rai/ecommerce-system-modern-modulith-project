package com.upendra.ecommerce.product.module.service;

import java.util.List;

import com.upendra.ecommerce.product.module.entities.Product;

public interface ProductService {

	Product createProduct(Product product);

	Product getProductById(Long id);

	List<Product> getAllProducts();

	Product updateProduct(Long id, Product product);

	void deleteProduct(Long id);
}