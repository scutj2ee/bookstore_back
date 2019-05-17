package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.entity.OrderItem;
import com.scutj2ee.bookstore.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/18 0:20
 * @description:
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public Order findById() {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public double getMoneySum() {
        return 0;
    }

    @Override
    public int getUserSum() {
        return 0;
    }

    @Override
    public List<OrderItem> findItems(Integer orderId) {
        return null;
    }

    @Override
    public void updateStatus(Integer id, int status) {

    }

    @Override
    public void update(Order order) {

    }

    @Override
    public void create(Order order) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public List<Order> findUserOrder(HttpServletRequest request) {
        return null;
    }

    @Override
    public void pay(Integer orderId, HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    public void submit(Integer addressId, HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    @Override
    public void receive(Integer orderId) {

    }
}
