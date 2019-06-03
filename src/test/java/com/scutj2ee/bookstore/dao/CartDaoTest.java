package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/26 15:50
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CartDaoTest {
    @Autowired
    private CartDao cartDao;

    @Test
    public void deleteCart() {
        cartDao.deleteCart(1);
    }

    @Test
    public void insertCart() {
        Cart cart=new Cart();
        cart.setUserId(1);
        cart.setSubTotal(1.0);
        cart.setId(2);
        cartDao.insertCart(cart);
    }
}