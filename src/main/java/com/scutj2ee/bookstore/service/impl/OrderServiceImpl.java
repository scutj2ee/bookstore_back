package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.*;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.entity.OrderItem;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/18 0:20
 * @description:
 */
@Service
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
    public List<OrderItem> findItems(Integer orderId) {
        List<OrderItem> list = orderItemDao.findByOrderId(orderId);
        for (OrderItem orderItem : list) {
            BookInfo bookInfo = bookInfoDao.findBookInfoById(orderItem.getBookId());
            orderItem.setBookInfo(bookInfo);
        }
        return list;
    }

    @Override
    public void updateStatus(Integer id, int status) {
        Order order = orderDao.findOrderById(id);
        order.setStatus(status);
        orderDao.updateOrder(order);
    }

    @Override
    public int update(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public int create(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public int deleteById(Integer id) {
        return orderDao.deleteOrder(id);
    }

    @Override
    public PageInfo<Order> findUserOrder(Integer userId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<Order> list = orderDao.findByUserId(userId);
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Order> pageinfo = new PageInfo<>(list);
        return pageinfo;
    }


    @Override
    public void pay(Integer orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Order order = orderDao.findOrderById(orderId);
        Object user = request.getSession().getAttribute("user");
        User loginUser = (User) user;
        if (order == null) {
            throw new RuntimeException("订单不存在！");
        }
        loginUser.setIntegration(order.getTotalIntegral() + loginUser.getIntegration());
        userDao.updateUser(loginUser);
        order.setStatus(STATE_WAITE_SEND);
        order.setEndTime(new Date());
        orderDao.updateOrder(order);
    }


    @Override
    public void submit(Integer addressId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
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
        if (order == null) {
            throw new RuntimeException("订单不存在！");
        }
        order.setStatus(STATE_COMPLETE);
        orderDao.updateOrder(order);
    }

    @Override
    public PageInfo<Order> getOrderList(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<Order> list = orderDao.getOrderListByParams();
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int updateOrderByOrderNoAndPayNo(String out_trade_no, String trade_no) {
        return orderDao.updateOrderByOrderNoAndPayNo(out_trade_no, trade_no);
    }

    @Override
    public Order findByOrderNo(String out_trade_no) {
        return orderDao.findByOrderNo(out_trade_no);
    }
}
