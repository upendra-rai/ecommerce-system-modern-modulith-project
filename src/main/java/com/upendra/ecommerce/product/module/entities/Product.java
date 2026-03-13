package com.upendra.ecommerce.product.module.entities;

import java.math.BigDecimal;

import com.upendra.ecommerce.util.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product extends BaseEntity {

	@Column(name = "name", nullable = false, length = 150)
	private String name;

	@Column(name = "description", length = 500)
	private String description;

	@Column(name = "sku", unique = true, nullable = false, length = 50)
	private String sku;

	@DecimalMin(value = "0.0")
	@Column(name = "price", nullable = false, precision = 10, scale = 2)
	private BigDecimal price;

	@DecimalMin(value = "0.0")
	@Column(name = "cost_price", precision = 10, scale = 2)
	private BigDecimal costPrice;

	@Min(0)
	@Column(name = "quantity_in_stock", nullable = false)
	private Integer quantityInStock;

	@Column(name = "category", length = 100)
	private String category;

	@Column(name = "brand", length = 100)
	private String brand;
}