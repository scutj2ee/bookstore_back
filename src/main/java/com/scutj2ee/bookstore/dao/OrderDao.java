package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Order;

import java.util.List;

public interface OrderDao {
    int deleteOrder(Integer id);

    int insertOrder(Order order);

    Order findOrderById(Integer id);

    List<Order> selectAll();

    int updateOrder(Order order);
}