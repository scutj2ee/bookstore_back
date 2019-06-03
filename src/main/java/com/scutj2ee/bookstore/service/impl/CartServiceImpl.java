package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
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
    public Cart findCartById(Integer  id) {
        return cartDao.findCartById(id);
    }

    @Override
    public int addCartItem(Integer userId,Integer bookId,Double subTotal,Integer buyNum) {
        //根据userId获取cartId
        Cart cart=cartDao.findByUserId(userId);
        Integer cartId=cart.getId();
        //添加新的CartItem
        CartItem cartItem=new CartItem();
        cartItem.setBookId(bookId);
        cartItem.setCartId(cartId);
        cartItem.setBuyNum(buyNum);
        cartItem.setSubTotal(subTotal);
        return cartItemDao.insertCartItem(cartItem);
    }

    @Override
    public int removeCartItem(Integer cartItemId){
        return cartItemDao.deleteCartItem(cartItemId);
    }

    @Override
    public PageInfo<CartItem> listCart(Integer userId, Integer pageNo, Integer pageSize){
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        //根据userId获取cartId
        Cart cart=cartDao.findByUserId(userId);
        Integer cartId=cart.getId();
        //根据cartId获取cartId获取List<cartItem>
        List<CartItem> cartItemList=cartItemDao.selectAll(cartId);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<CartItem> pageInfo = new PageInfo<>(cartItemList);
        return pageInfo;
    }

    @Override
    public int clearAll(Integer userId) {
        //根据userId获取cartId
        Cart cart=cartDao.findByUserId(userId);
        Integer cartId=cart.getId();
        return cartItemDao.clearAll(cartId);
    }

    @Override
    public int updateCartItem(CartItem cartItem) {
        return cartItemDao.updateCartItem(cartItem);
    }

    @Override
    public CartItem findCartItemById(Integer  cartItemId) {
        return cartItemDao.findCartItemById(cartItemId);
    }
}
