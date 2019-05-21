package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.CartItem;

import java.util.List;

public interface CartItemDao {
    int deleteCartItem(Integer id);

    int insertCartItem(CartItem cartItem);

    CartItem findCartItemById(Integer id);

    List<CartItem> selectAll(int cartId);

    int updateCartItem(CartItem cartItem);
}