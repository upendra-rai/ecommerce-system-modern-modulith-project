package com.upendra.ecommerce.payment.module.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.ecommerce.payment.module.entities.Payment;
import com.upendra.ecommerce.payment.module.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Payment API", description = "Payment operations")
public class PaymentController {

	private final PaymentService paymentService;

	@PostMapping
	@Operation(summary = "Create payment")
	public Payment createPayment(@RequestBody Payment payment) {
		log.info("REST request to create payment");
		return paymentService.createPayment(payment);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get payment by id")
	public Payment getPayment(@PathVariable Long id) {
		log.info("REST request to fetch payment {}", id);
		return paymentService.getPaymentById(id);
	}

	@GetMapping
	@Operation(summary = "Get all payments")
	public List<Payment> getAllPayments() {
		log.info("REST request to fetch all payments");
		return paymentService.getAllPayments();
	}

	@PutMapping("/{id}/status")
	@Operation(summary = "Update payment status")
	public Payment updateStatus(@PathVariable Long id, @RequestParam String status) {
		log.info("REST request to update payment status {}", id);
		return paymentService.updatePaymentStatus(id, status);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete payment")
	public void deletePayment(@PathVariable Long id) {
		log.info("REST request to delete payment {}", id);
		paymentService.deletePayment(id);
	}
}