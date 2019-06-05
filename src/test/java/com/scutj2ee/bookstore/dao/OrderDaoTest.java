package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.utils.RandomUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/5 10:14
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

    @Test
    public void insertOrder() {
        Order order=new Order();
        order.setId(RandomUtil.getRandomOrderId());
        order.setAddressId(1);
        order.setUserId(1);
        order.setDelete(false);
        order.setCreateTime(new Date());
        order.setEndTime(new Date());
        order.setStatus(1);
        order.setPayment(1.0);
        orderDao.insertOrder(order);
    }

    @Test
    public void selectOrder() {
        orderDao.selectAll();
    }

    @Test
    public void deleteOrder() {
        orderDao.deleteOrder(1);
    }

    @Test
    public void findIdsByUserId() {
        List<Integer> list=orderDao.findIdsByUserId(1);
        for(Integer i:list){
            System.out.println(i);
        }
    }
}