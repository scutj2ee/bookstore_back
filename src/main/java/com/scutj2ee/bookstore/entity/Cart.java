package com.scutj2ee.bookstore.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
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

    @Transient
    private Map<Integer, CartItem> cartItems = new HashMap<>();

    private Double total;

    private Integer userId;

    public Cart() {
    }

    public Cart(Integer id, Map<Integer, CartItem> cartItems, Double total, int userId) {
        this.id = id;
        this.cartItems = cartItems;
        this.total = total;
        this.userId = userId;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
