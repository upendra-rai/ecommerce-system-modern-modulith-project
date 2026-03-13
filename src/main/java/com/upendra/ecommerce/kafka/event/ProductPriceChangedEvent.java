package com.upendra.ecommerce.kafka.event;

import java.math.BigDecimal;

public record ProductPriceChangedEvent(Long productId, String productName, BigDecimal oldPrice, BigDecimal newPrice) {
}