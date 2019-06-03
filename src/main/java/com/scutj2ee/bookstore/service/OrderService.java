package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookInfo;
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
     * 订单状态 1：未付款 2：等待发货 4：订单完成
     */
    int STATE_NO_PAY = 1;
    int STATE_WAITE_SEND = 2;
    int STATE_WAITE_RECEIVE = 3;
    int STATE_COMPLETE = 4;

    /**
     * 根据id查询
     */
    Order findById(Integer orderId);

    /**
     * 查询所有订单
     */
    List<Order> findAll();

    /**
     * 查询订单的订单项
     * 分页
     * @param orderId
     * @param pageNo
     * @param pageSize
     * @return
     */

    PageInfo<OrderItem> findItems(Integer orderId, Integer pageNo, Integer pageSize);

    /**
     * 更新订单状态
     */
    void updateStatus(Integer id, int status);


    /**
     * 更新
     */
    int update(Order order);

    /**
     * 创建订单
     */
    int create(Order order);

    /**
     * 根据id查询
     */
    int deleteById(Integer id);

    /**
     * 查找用户订单
     * 使用分页
     * @param userId
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<Order> findUserOrder(Integer userId, Integer pageNo, Integer pageSize);

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

    /**
     * create by: Bin Liu
     * description: 查看所有订单
     * create time: 2019/5/26 15:18
     * @Param: null
     * @return
     */
    PageInfo<Order> getOrderList(Integer pageNo, Integer pageSize);

    /**
     * create by: Bin Liu
     * description: 通过流水号更新订单
     * create time: 2019/6/3 11:15
     * @Param: null
     * @return 
     */
    int updateOrderByOrderNoAndPayNo(String out_trade_no, String trade_no);

    /**
     * create by: Bin Liu
     * description: 通过订单流水号查找订单
     * create time: 2019/6/3 11:27
     * @Param: null
     * @return
     */
    Order findByOrderNo(String out_trade_no);
}
