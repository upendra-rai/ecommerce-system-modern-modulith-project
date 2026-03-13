package com.upendra.ecommerce.order.module.service;

import java.util.List;

import com.upendra.ecommerce.order.module.entities.Order;

public interface OrderService {

	Order createOrder(Order order);

	Order getOrderById(Long id);

	List<Order> getAllOrders();

	Order updateOrder(Long id, Order order);

	void deleteOrder(Long id);
}