package com.upendra.ecommerce.kafka.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.upendra.ecommerce.kafka.event.dto.ProductCreatedEvent;
import com.upendra.ecommerce.kafka.event.dto.ProductDeletedEvent;
import com.upendra.ecommerce.kafka.event.dto.ProductOutOfStockEvent;
import com.upendra.ecommerce.kafka.event.dto.ProductUpdatedEvent;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class NotificationService {

	@EventListener
	public void notifyOnProductCreated(ProductCreatedEvent event) {
		log.info("Notification: Product '{}' created with price {}", event.productName(), event.price());
		// Example: send email / push notification
	}

	@EventListener
	public void notifyOnProductUpdated(ProductUpdatedEvent event) {
		log.info("Notification: Product '{}' has been updated", event.productName());
	}

	@EventListener
	public void notifyOnProductDeleted(ProductDeletedEvent event) {
		log.warn("Notification: Product '{}' has been removed", event.productName());
	}

	@EventListener
	public void notifyOnOutOfStock(ProductOutOfStockEvent event) {
		log.error("Notification: Product '{}' is OUT OF STOCK!", event.productName());

		// Example: notify admin or restock system
	}

	@EventListener
	public void notifyOnPriceChange(ProductPriceChangedEvent event) {
		log.info("Notification: Price for '{}' changed from {} to {}", event.productName(), event.oldPrice(),
				event.newPrice());

		// Example: notify customers watching this product
	}
}
