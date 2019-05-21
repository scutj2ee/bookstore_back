package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Cart;
import jdk.internal.org.objectweb.asm.commons.AdviceAdapter;

import java.util.List;

public interface CartDao {
    int deleteCart(Integer id);

    int insertCart(Cart cart);

    Cart findCartById(Integer id);

    List<Cart> selectAll();

    int updateCart(Cart cart);

    /**
     * create by: Kobe
     * description:根据用户Id查找购物车
     * create time: 15:38 2019/5/21
     * @param userId
     * @return
     */
    int findByUserId(int userId);
}