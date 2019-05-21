package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.CartItem;

import java.util.List;

public interface CartItemDao {
    int deleteCartItem(Integer id);

    int insertCartItem(CartItem cartItem);

    CartItem findCartItemById(Integer id);

    List<CartItem> selectAll(int cartId);

    int updateCartItem(CartItem cartItem);

    /**
     * create by: Kobe
     * description:清空购物车
     * create time: 20:59 2019/5/21
     * @return int
     */
    int clearAll(int cartId);
}