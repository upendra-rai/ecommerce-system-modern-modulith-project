package com.upendra.ecommerce.kafka.event.dto;

import java.math.BigDecimal;

public record ProductCreatedEvent(Long productId, String productName, BigDecimal price) {
}