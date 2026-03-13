package com.upendra.ecommerce.payment.service;
import java.util.List;

import com.upendra.ecommerce.payment.entities.Payment;

public interface PaymentService {

    Payment createPayment(Payment payment);

    Payment getPaymentById(Long id);

    List<Payment> getAllPayments();

    Payment updatePaymentStatus(Long id, String status);

    void deletePayment(Long id);
}