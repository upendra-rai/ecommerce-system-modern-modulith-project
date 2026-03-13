package com.upendra.ecommerce.kafka.event.dto;

import java.math.BigDecimal;

public record ProductPriceChangedEvent(Long productId, String productName, BigDecimal oldPrice, BigDecimal newPrice) {
}