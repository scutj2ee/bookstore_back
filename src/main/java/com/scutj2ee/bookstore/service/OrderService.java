package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.entity.OrderItem;
import com.scutj2ee.bookstore.model.dto.CommentBookDto;

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
     * 订单状态 1：未付款 2：等待发货 3:等待收货 4：订单完成
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
     * @return
     */
    List<OrderItem> findItems(Integer orderId);

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
     * @Author Bin Liu
     * @Description 支付
     * @Date 2019/6/4 15:35
     * @param orderId
     * @param userId
     * @return 
     */
    int pay(Integer orderId,Integer userId) ;

    /**
     * @Author Bin Liu
     * @Description 提交购物车项并生成订单
     * @Date 2019/6/4 15:08
     * @param userId
     * @param addressId
     * @param cartIds
     * @return
     */
    int submit(Integer userId, Integer addressId, List<Integer> cartIds);

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

    /**
     * @Author Bin Liu
     * @Description 获取该订单下的所有书本
     * @Date 2019/6/5 12:40
     * @param 
     * @return 
     */
    List<CommentBookDto> getBookList(Integer orderId);
}
