package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {
    int deleteOrderItem(Integer id);

    int insertOrderItem(OrderItem orderItem);

    OrderItem selectOrderItemById(Integer id);

    List<OrderItem> selectAll();

    int updateOrderItem(OrderItem orderItem);
}