package com.upendra.ecommerce.cart.module.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.upendra.ecommerce.cart.module.entities.Cart;
import com.upendra.ecommerce.cart.module.service.CartService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/cart")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "Cart API", description = "Operations for shopping cart")
public class CartController {

	private final CartService cartService;

	@GetMapping("/{userId}")
	@Operation(summary = "Get cart by user")
	public Cart getCart(@PathVariable Long userId) {
		log.info("REST request to get cart for user {}", userId);
		return cartService.getCartByUser(userId);
	}

	@PostMapping("/add")
	@Operation(summary = "Add product to cart")
	public Cart addProduct(@RequestParam Long userId, @RequestParam Long productId, @RequestParam Integer quantity) {
		log.info("REST request to add product {} to cart", productId);
		return cartService.addProductToCart(userId, productId, quantity);
	}

	@PutMapping("/update")
	@Operation(summary = "Update product quantity")
	public Cart updateQuantity(@RequestParam Long cartItemId, @RequestParam Integer quantity) {
		log.info("REST request to update cart item {}", cartItemId);
		return cartService.updateQuantity(cartItemId, quantity);
	}

	@DeleteMapping("/remove/{cartItemId}")
	@Operation(summary = "Remove item from cart")
	public void removeItem(@PathVariable Long cartItemId) {
		log.info("REST request to remove cart item {}", cartItemId);
		cartService.removeItem(cartItemId);
	}

	@DeleteMapping("/clear/{userId}")
	@Operation(summary = "Clear cart")
	public void clearCart(@PathVariable Long userId) {
		log.info("REST request to clear cart for user {}", userId);
		cartService.clearCart(userId);
	}
}