package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Order;

import java.util.List;

public interface OrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectAll();

    int updateByPrimaryKey(Order record);
}