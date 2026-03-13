package com.upendra.ecommerce.product.module.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.ecommerce.product.module.entities.Product;
import com.upendra.ecommerce.product.module.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Product API", description = "CRUD operations for Product")
public class ProductController {

	private final ProductService productService;

	@PostMapping
	@Operation(summary = "Create a new product")
	public Product createProduct(@RequestBody Product product) {
		log.info("REST request to create product");
		return productService.createProduct(product);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get product by ID")
	public Product getProduct(@PathVariable Long id) {
		log.info("REST request to get product {}", id);
		return productService.getProductById(id);
	}

	@GetMapping
	@Operation(summary = "Get all products")
	public List<Product> getAllProducts() {
		log.info("REST request to get all products");
		return productService.getAllProducts();
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update product")
	public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
		log.info("REST request to update product {}", id);
		return productService.updateProduct(id, product);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete product")
	public void deleteProduct(@PathVariable Long id) {
		log.info("REST request to delete product {}", id);
		productService.deleteProduct(id);
	}
}
