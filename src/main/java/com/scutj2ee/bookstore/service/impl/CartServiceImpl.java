package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.CartDao;
import com.scutj2ee.bookstore.dao.CartItemDao;
import com.scutj2ee.bookstore.entity.Cart;
import com.scutj2ee.bookstore.entity.CartItem;
import com.scutj2ee.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public int addCartItem(CartItem cartItem) {
        return cartItemDao.insertCartItem(cartItem);
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
    public int clearAll(int cartId) {
        return cartItemDao.clearAll(cartId);
    }

    @Override
    public int updateCartItem(CartItem cartItem) {
        return cartItemDao.updateCartItem(cartItem);
    }

    @Override
    public CartItem findCartItemById(int cartItemId) {
        return cartItemDao.findCartItemById(cartItemId);
    }

    @Override
    public PageInfo<CartItem> getCartItemList(Map map, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<CartItem> list = cartItemDao.getCartItemListByParams(map);
        PageInfo<CartItem> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
