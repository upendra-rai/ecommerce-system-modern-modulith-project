package com.upendra.ecommerce.order.module.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.upendra.ecommerce.util.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order extends BaseEntity {

	private Long productId;

	@Column(name = "order_number", nullable = false, unique = true)
	private String orderNumber;

	@Column(name = "customer_name", nullable = false)
	private String customerName;

	@Column(name = "customer_email")
	private String customerEmail;

	@Column(name = "total_amount", nullable = false)
	private BigDecimal totalAmount;

	@Column(name = "status")
	private String status; // CREATED, SHIPPED, DELIVERED

	@Column(name = "order_date")
	private LocalDateTime orderDate;

}