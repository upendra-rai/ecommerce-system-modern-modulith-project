package com.upendra.ecommerce.kafka.event.dto;

public record ProductUpdatedEvent(Long productId, String productName) {
}