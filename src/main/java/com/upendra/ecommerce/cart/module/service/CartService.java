package com.upendra.ecommerce.cart.module.service;

import com.upendra.ecommerce.cart.module.entities.Cart;

public interface CartService {

    Cart getCartByUser(Long userId);

    Cart addProductToCart(Long userId, Long productId, Integer quantity);

    Cart updateQuantity(Long cartItemId, Integer quantity);

    void removeItem(Long cartItemId);

    void clearCart(Long userId);
}