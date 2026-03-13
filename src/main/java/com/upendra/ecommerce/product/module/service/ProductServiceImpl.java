package com.upendra.ecommerce.product.module.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upendra.ecommerce.product.module.entities.Product;
import com.upendra.ecommerce.product.module.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

	private final ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		log.info("Creating product with SKU: {}", product.getSku());
		if (productRepository.existsBySku(product.getSku())) {
			throw new RuntimeException("Product with SKU already exists");
		}
		return productRepository.save(product);
	}

	@Override
	public Product getProductById(Long id) {
		log.info("Fetching product with id: {}", id);
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
	}

	@Override
	public List<Product> getAllProducts() {
		log.info("Fetching all products");
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		log.info("Updating product id: {}", id);
		Product existing = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
		existing.setName(product.getName());
		existing.setDescription(product.getDescription());
		existing.setPrice(product.getPrice());
		existing.setCostPrice(product.getCostPrice());
		existing.setQuantityInStock(product.getQuantityInStock());
		existing.setBrand(product.getBrand());
		existing.setCategory(product.getCategory());
		existing.setActive(product.isActive());
		return productRepository.save(existing);
	}

	@Override
	public void deleteProduct(Long id) {
		log.info("Deleting product id: {}", id);
		Product product = getProductById(id);
		productRepository.delete(product);
	}
}