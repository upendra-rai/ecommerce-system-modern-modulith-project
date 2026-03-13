package com.upendra.ecommerce.cart.module.service;

import org.springframework.stereotype.Service;

import com.upendra.ecommerce.cart.module.entities.Cart;
import com.upendra.ecommerce.cart.module.entities.CartItem;
import com.upendra.ecommerce.cart.module.repository.CartItemRepository;
import com.upendra.ecommerce.cart.module.repository.CartRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartServiceImpl implements CartService {

	private final CartRepository cartRepository;
	private final CartItemRepository cartItemRepository;

	@Override
	public Cart getCartByUser(Long userId) {
		log.info("Fetching cart for user {}", userId);
		return cartRepository.findByUserId(userId)
				.orElseGet(() -> cartRepository.save(Cart.builder().userId(userId).build()));
	}

	@Override
	public Cart addProductToCart(Long userId, Long productId, Integer quantity) {
		log.info("Adding product {} to cart for user {}", productId, userId);
		Cart cart = getCartByUser(userId);
		CartItem item = CartItem.builder().cart(cart).productId(productId).quantity(quantity).build();
		cartItemRepository.save(item);
		return cartRepository.findById(cart.getId()).orElseThrow();
	}

	@Override
	public Cart updateQuantity(Long cartItemId, Integer quantity) {
		log.info("Updating cart item {} quantity {}", cartItemId, quantity);
		CartItem item = cartItemRepository.findById(cartItemId)
				.orElseThrow(() -> new RuntimeException("Cart item not found"));
		item.setQuantity(quantity);
		cartItemRepository.save(item);
		return item.getCart();
	}

	@Override
	public void removeItem(Long cartItemId) {
		log.info("Removing cart item {}", cartItemId);
		cartItemRepository.deleteById(cartItemId);
	}

	@Override
	public void clearCart(Long userId) {
		log.info("Clearing cart for user {}", userId);
		Cart cart = cartRepository.findByUserId(userId).orElseThrow(() -> new RuntimeException("Cart not found"));
		cart.getItems().clear();
		cartRepository.save(cart);
	}
}