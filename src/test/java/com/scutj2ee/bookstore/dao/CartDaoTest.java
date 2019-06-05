package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Cart;
import com.scutj2ee.bookstore.utils.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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
        cart.setBookId(1);
        cart.setBuyNum(1);
        cart.setId(RandomUtil.getRandomOrderId());
        System.out.println(cartDao.insertCart(cart));
    }

    @Test
    public void getCartListParams(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        cartDao.getCartListParams(list);
    }
}