package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.CartDao;
import com.scutj2ee.bookstore.dao.CartItemDao;
import com.scutj2ee.bookstore.entity.CartItem;
import com.scutj2ee.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author kobe
 * @Date 2019/5/21 15:10
 * @Description:
 * @Modified By:
 */
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public void addCartItem(CartItem cartItem) throws Exception {
        cartItemDao.insertCartItem(cartItem);
    }

    @Override
    public int removeCartItem(int cartItemId) throws Exception {
        return cartItemDao.deleteCartItem(cartItemId);
    }

    @Override
    public List<CartItem> listCart(int userId) throws Exception {
        return cartItemDao.selectAll(cartDao.findByUserId(userId));
    }
}
