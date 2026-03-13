package com.upendra.ecommerce.cart.module.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upendra.ecommerce.cart.module.entities.CartItem;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}