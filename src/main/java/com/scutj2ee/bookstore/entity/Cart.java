package com.scutj2ee.bookstore.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/3 9:56
 * @ Description： 购物车实体类
 * @ Modified By：
 */
public class Cart {
    private Map<Integer, CartItem> cartItems = new HashMap<>();

    private double total;

    public Map<Integer, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Integer, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
