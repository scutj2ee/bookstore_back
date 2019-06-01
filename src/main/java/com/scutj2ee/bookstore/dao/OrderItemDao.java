package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.OrderItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OrderItemDao {
    int deleteOrderItem(Integer id);

    int insertOrderItem(OrderItem orderItem);

    OrderItem findOrderItemById(Integer id);

    List<OrderItem> selectAll();

    int updateOrderItem(OrderItem orderItem);

    List<OrderItem> findByOrderId(Integer orderId);
}