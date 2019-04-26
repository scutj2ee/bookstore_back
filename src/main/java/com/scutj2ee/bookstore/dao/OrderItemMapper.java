package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.OrderItem;

import java.util.List;

public interface OrderItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItem record);

    OrderItem selectByPrimaryKey(Integer id);

    List<OrderItem> selectAll();

    int updateByPrimaryKey(OrderItem record);
}