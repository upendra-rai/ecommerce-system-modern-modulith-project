package com.upendra.ecommerce.payment.module.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upendra.ecommerce.payment.module.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	Optional<Payment> findByTransactionId(String transactionId);

}