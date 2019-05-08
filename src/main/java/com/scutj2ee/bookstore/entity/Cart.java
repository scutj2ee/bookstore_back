package com.scutj2ee.bookstore.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/3 9:56
 * @ Description： 购物车实体类
 * @ Modified By：
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Map<Integer, CartItem> cartItems = new HashMap<>();

    private double total;

    public Cart(Integer id, Map<Integer, CartItem> cartItems, double total) {
        this.id = id;
        this.cartItems = cartItems;
        this.total = total;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
