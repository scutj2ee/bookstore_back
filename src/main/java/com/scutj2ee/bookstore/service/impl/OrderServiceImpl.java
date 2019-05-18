package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.*;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.entity.OrderItem;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/18 0:20
 * @description:
 */
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private BookInfoDao bookInfoDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Order findById(Integer orderId) {
        return orderDao.findOrderById(orderId);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.selectAll();
    }

    @Override
    public double getMoneySum() {
        return 0;
    }

    @Override
    public int getUserSum() {
        return 0;
    }

    /**
     * 暂时未实现Dao
     * @param orderId
     * @return
     */
    @Override
    public List<OrderItem> findItems(Integer orderId) {
        return null;
    }

    @Override
    public void updateStatus(Integer id, int status) {
        Order order = orderDao.findOrderById(id);
        order.setStatus(status);
        orderDao.updateOrder(order);
    }

    @Override
    public void update(Order order) {
        orderDao.updateOrder(order);
    }

    @Override
    public int create(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public void deleteById(Integer id) {
        orderDao.deleteOrder(id);
    }

    /**
     * 查询用户订单
     * Dao未完暂时不开法
     * @param request
     * @return
     */
    @Override
    public List<Order> findUserOrder(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user");
        if(user == null){
            throw new LoginException("请登录！");
        }
        User loginUser = (User) user;

        return null;
    }

    @Override
    public void pay(Integer orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Order order = orderDao.findOrderById(orderId);
        Object user = request.getSession().getAttribute("user");
        User loginUser = (User) user;
        if(order == null){
            throw new RuntimeException("订单不存在！");
        }
        loginUser.setIntegration(order.getTotalIntegral()+loginUser.getIntegration());
        userDao.updateUser(loginUser);
        order.setStatus(STATE_WAITE_SEND);
        order.setEndTime(new Date());
        orderDao.updateOrder(order);
    }


    @Override
    public void submit(Integer addressId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if(user == null){
            throw new LoginException("请登录！");
        }
        User loginUser = (User) user;
        Order order = new Order();
        order.setAddressId(addressId);
        order.setCreateTime(new Date());
        order.setUserId(loginUser.getId());
        order.setStatus(STATE_NO_PAY);
        order.setTotalIntegral(0);
        order.setPayment(0.0);
        /**
         * 此处订单由购物车处产生，但是购物车还未开发，所以暂时不写
         */


    }

    @Override
    public void receive(Integer orderId) {
        Order order = orderDao.findOrderById(orderId);
        if(order ==  null) {
            throw new RuntimeException("订单不存在！");
        }
        order.setStatus(STATE_COMPLETE);
        orderDao.updateOrder(order);
    }
}
