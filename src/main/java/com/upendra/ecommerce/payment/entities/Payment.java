package com.upendra.ecommerce.payment.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.upendra.ecommerce.util.BaseEntity;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment extends BaseEntity {

	@Column(name = "order_id", nullable = false)
	private Long orderId;

	@Column(name = "payment_method")
	private String paymentMethod; // CARD, UPI, NETBANKING, COD

	@Column(name = "transaction_id")
	private String transactionId;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	@Column(name = "status")
	private String status; // CREATED, SUCCESS, FAILED

	@Column(name = "payment_date")
	private LocalDateTime paymentDate;
}
