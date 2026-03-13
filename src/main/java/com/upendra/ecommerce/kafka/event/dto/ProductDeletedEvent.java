package com.upendra.ecommerce.kafka.event.dto;

public record ProductDeletedEvent(Long productId, String productName) {
}