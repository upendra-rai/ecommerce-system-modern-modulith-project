package com.upendra.ecommerce.order.module.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.ecommerce.order.module.entities.Order;
import com.upendra.ecommerce.order.module.service.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Order API", description = "CRUD operations for Orders")
public class OrderController {

	private final OrderService orderService;

	@PostMapping
	@Operation(summary = "Create order")
	public Order createOrder(@RequestBody Order order) {
		log.info("REST request to create order");
		return orderService.createOrder(order);
	}

	@GetMapping("/{id}")
	@Operation(summary = "Get order by ID")
	public Order getOrder(@PathVariable Long id) {
		log.info("REST request to fetch order {}", id);
		return orderService.getOrderById(id);
	}

	@GetMapping
	@Operation(summary = "Get all orders")
	public List<Order> getAllOrders() {
		log.info("REST request to fetch all orders");
		return orderService.getAllOrders();
	}

	@PutMapping("/{id}")
	@Operation(summary = "Update order")
	public Order updateOrder(@PathVariable Long id, @RequestBody Order order) {
		log.info("REST request to update order {}", id);
		return orderService.updateOrder(id, order);
	}

	@DeleteMapping("/{id}")
	@Operation(summary = "Delete order")
	public void deleteOrder(@PathVariable Long id) {
		log.info("REST request to delete order {}", id);
		orderService.deleteOrder(id);
	}
}