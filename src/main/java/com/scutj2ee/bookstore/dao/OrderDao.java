package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderDao {
    int deleteOrder(Integer id);

    int insertOrder(Order order);

    Order findOrderById(Integer id);

    List<Order> selectAll();

    int updateOrder(Order order);

    List<Order> findByUserId(Integer userId);

    List<Order> getOrderListByParams();

    Order findByOrderNo(String out_trade_no);

    int updateOrderByOrderNoAndPayNo(@Param("out_trade_no")String out_trade_no, @Param("trade_no")String trade_no);

    int updateStatus(int status, Integer id);

    List<Integer> findIdsByUserId(Integer userId);
}