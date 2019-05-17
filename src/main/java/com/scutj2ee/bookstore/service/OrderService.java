package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.entity.OrderItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/17 23:03
 * @description:
 */
public interface OrderService {
    /**
     * 订单状态 1：未付款 2：等待发货 3：等待收货 4：订单完成
     */
    int STATE_NO_PAY = 1;
    int STATE_WAITE_SEND = 2;
    int STATE_WAITE_RECEIVE = 3;
    int STATE_COMPLETE = 4;

    /**
     * 根据id查询
     */
    Order findById();

    /**
     * 查询所有订单
     */
    List<Order> findAll();

    /**
     * 查询历史订单
     */
    double getMoneySum();

    /**
     * 获取用户总数
     */
    int getUserSum();

    /**
     * 查询订单的订单项
     */
    List<OrderItem> findItems(Integer orderId);

    /**
     * 更新订单状态
     */
    void updateStatus(Integer id, int status);


    /**
     * 更新
     */
    void update(Order order);

    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 根据id查询
     */
    void deleteById(Integer id);

    /**
     * 查找用户订单
     */
    List<Order> findUserOrder(HttpServletRequest request);

    /**
     * 支付
     */
    void pay(Integer orderId, HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 提交订单
     */
    void submit(Integer addressId, HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 确定收货
     */
    void receive(Integer orderId);
}
