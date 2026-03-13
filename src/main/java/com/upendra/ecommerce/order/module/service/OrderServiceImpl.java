package com.upendra.ecommerce.order.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.upendra.ecommerce.order.module.entities.Order;
import com.upendra.ecommerce.order.module.repository.OrderRepository;
import com.upendra.ecommerce.product.module.entities.Product;
import com.upendra.ecommerce.product.module.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Order createOrder(Order order) {
		log.info("Creating order: {}", order);
		Product product = productRepository.findById(order.getProductId())
				.orElseThrow(() -> new RuntimeException("Order not found"));
		order.setProductId(product.getId());
		return orderRepository.save(order);
	}

	@Override
	public Order getOrderById(Long id) {
		log.info("Fetching order id: {}", id);
		return orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
	}

	@Override
	public List<Order> getAllOrders() {
		log.info("Fetching all orders");
		return orderRepository.findAll();
	}

	@Override
	public Order updateOrder(Long id, Order order) {
		log.info("Updating order id: {}", id);
		Order existing = getOrderById(id);

		existing.setCustomerName(order.getCustomerName());
		existing.setCustomerEmail(order.getCustomerEmail());
		existing.setTotalAmount(order.getTotalAmount());
		existing.setStatus(order.getStatus());

		return orderRepository.save(existing);
	}

	@Override
	public void deleteOrder(Long id) {
		log.info("Deleting order id: {}", id);
		Order order = getOrderById(id);
		orderRepository.delete(order);
	}
}