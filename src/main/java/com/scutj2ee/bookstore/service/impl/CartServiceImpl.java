package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.BookInfoDao;
import com.scutj2ee.bookstore.dao.CartDao;
import com.scutj2ee.bookstore.entity.BookInfo;
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
    @Autowired
    private BookInfoDao bookInfoDao;

    @Override
    public int addCart(Integer userId,Integer bookId,Double subTotal,Integer buyNum) {
        //根据userId获取cart
        Cart cart=cartDao.findCartByBookIdAndUserId(bookId,userId);
        Cart cart1=new Cart(  );
        //如果cart存在则更新，不存在则添加
        if(cart==null){
            cart1.setUserId(userId);
            cart1.setBookId(bookId);
            cart1.setBuyNum(buyNum);
            cart1.setSubTotal(subTotal);
            return cartDao.insertCart(cart1);
        }else {
            //如果cart已经存在，则叠加
            cart.setSubTotal(cart.getSubTotal()+subTotal);
            cart.setBuyNum(cart.getBuyNum()+buyNum);
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
        for(Cart cart:cartList){
            BookInfo bookInfo=bookInfoDao.findBookInfoById(cart.getBookId());
            cart.setBookInfo(bookInfo);
        }
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
        Cart cart=cartDao.findCartByBookIdAndUserId(bookId,userId);
        cart.setSubTotal(subTotal);
        cart.setBuyNum(buyNum);
        return cartDao.updateCart(cart);
    }
}
