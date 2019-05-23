package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.CartDao;
import com.scutj2ee.bookstore.dao.CartItemDao;
import com.scutj2ee.bookstore.entity.Cart;
import com.scutj2ee.bookstore.entity.CartItem;
import com.scutj2ee.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author kobe
 * @Date 2019/5/21 15:10
 * @Description:
 * @Modified By:
 */
@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Autowired
    private CartItemDao cartItemDao;

    @Override
    public Cart findCartById(int id) {
        return cartDao.findCartById(id);
    }

    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDao.insertCartItem(cartItem);
    }

    @Override
    public int removeCartItem(int cartItemId){
        return cartItemDao.deleteCartItem(cartItemId);
    }

    @Override
    public List<CartItem> listCart(int userId){
        return cartItemDao.selectAll(cartDao.findByUserId(userId));
    }

    @Override
    public void clearAll(int cartId) {
        cartItemDao.clearAll(cartId);
    }

    @Override
    public int updateCartItem(CartItem cartItem) {
        return cartItemDao.updateCartItem(cartItem);
    }

    @Override
    public CartItem findCartItemById(int cartItemId) {
        return cartItemDao.findCartItemById(cartItemId);
    }
}
