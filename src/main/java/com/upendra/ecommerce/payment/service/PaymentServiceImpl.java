package com.upendra.ecommerce.payment.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.upendra.ecommerce.payment.entities.Payment;
import com.upendra.ecommerce.payment.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentServiceImpl implements PaymentService {

	private final PaymentRepository paymentRepository;

	@Override
	public Payment createPayment(Payment payment) {
		log.info("Creating payment for order {}", payment.getOrderId());
		payment.setPaymentDate(LocalDateTime.now());
		payment.setStatus("CREATED");
		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPaymentById(Long id) {
		log.info("Fetching payment {}", id);
		return paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
	}

	@Override
	public List<Payment> getAllPayments() {
		log.info("Fetching all payments");
		return paymentRepository.findAll();
	}

	@Override
	public Payment updatePaymentStatus(Long id, String status) {
		log.info("Updating payment {} status {}", id, status);
		Payment payment = paymentRepository.findById(id).orElseThrow(() -> new RuntimeException("Payment not found"));
		payment.setStatus(status);
		return paymentRepository.save(payment);
	}

	@Override
	public void deletePayment(Long id) {
		log.info("Deleting payment {}", id);
		paymentRepository.deleteById(id);
	}
}