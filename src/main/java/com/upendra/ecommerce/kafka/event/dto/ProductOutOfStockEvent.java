package com.upendra.ecommerce.kafka.event.dto;

public record ProductOutOfStockEvent(Long productId, String productName) {
}