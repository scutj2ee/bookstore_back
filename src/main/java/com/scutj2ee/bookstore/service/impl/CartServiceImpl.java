package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.CartDao;
import com.scutj2ee.bookstore.entity.Cart;
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

    @Override
    public int addCart(Integer userId,Integer bookId,Double subTotal,Integer buyNum) {
        //根据userId获取cart
        Cart cart=cartDao.findCartByBookIdAndUerId(bookId,userId);
        //如果cart存在则更新，不存在则添加
        if(cart==null){
            cart.setUserId(userId);
            cart.setBookId(bookId);
            cart.setBuyNum(buyNum);
            cart.setSubTotal(subTotal);
            return cartDao.insertCart(cart);
        }else {
            cart.setSubTotal(subTotal);
            cart.setBuyNum(buyNum);
            return cartDao.updateCart(cart);
        }
    }

    @Override
    public int removeCart(Integer userId,Integer bookId){
        return cartDao.deleteCartByUserIdAndBookId(userId,bookId);
    }

    @Override
    public PageInfo<Cart> listCart(Integer userId, Integer pageNo, Integer pageSize){
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        //根据userId获取List<Cart>
        List<Cart> cartList=cartDao.selectAll(userId);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Cart> pageInfo = new PageInfo<>(cartList);
        return pageInfo;
    }

    @Override
    public int clearAll(Integer userId) {
        return cartDao.clearAll(userId);
    }

    @Override
    public int updateCart(Integer bookId,Integer userId,Double subTotal,Integer buyNum) {
        //根据userId获取cart
        Cart cart=cartDao.findCartByBookIdAndUerId(bookId,userId);
        cart.setSubTotal(subTotal);
        cart.setBuyNum(buyNum);
        return cartDao.updateCart(cart);
    }
}
