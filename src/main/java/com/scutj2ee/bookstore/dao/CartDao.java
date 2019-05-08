package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Cart;

import java.util.List;

public interface CartDao {
    int deleteCart(Integer id);

    int insertCart(Cart cart);

    Cart findCartById(Integer id);

    List<Cart> selectAll();

    int updateCart(Cart cart);
}