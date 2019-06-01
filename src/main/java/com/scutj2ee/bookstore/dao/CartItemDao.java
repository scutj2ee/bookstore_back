package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.CartItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CartItemDao {
    int deleteCartItem(Integer id);

    int insertCartItem(CartItem cartItem);

    CartItem findCartItemById(Integer id);

    List<CartItem> selectAll(Integer cartId);

    int updateCartItem(CartItem cartItem);

    /**
     * create by: Kobe
     * description:清空购物车
     * create time: 20:59 2019/5/21
     * @return int
     */
    int clearAll(Integer cartId);

    List<CartItem> getCartItemListByParams(Map map);
}