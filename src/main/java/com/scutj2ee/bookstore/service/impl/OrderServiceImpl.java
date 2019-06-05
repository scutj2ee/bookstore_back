package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.*;
import com.scutj2ee.bookstore.entity.*;
import com.scutj2ee.bookstore.model.dto.CommentBookDto;
import com.scutj2ee.bookstore.service.OrderService;
import com.scutj2ee.bookstore.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/6 12:00
 * @ Description：订单业务逻辑实现类
 * @ Modified By：
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private OrderItemDao orderItemDao;
    @Autowired
    private BookInfoDao bookInfoDao;
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private CommentDao commentDao;

    @Override
    public Order findById(Integer orderId) {
        return orderDao.findOrderById(orderId);
    }

    @Override
    public List<Order> findAll() {
        return orderDao.selectAll();
    }

    @Override
    public List<OrderItem> findItems(Integer orderId) {
        List<OrderItem> list = orderItemDao.findByOrderId(orderId);
        for (OrderItem orderItem : list) {
            BookInfo bookInfo = bookInfoDao.findBookInfoById(orderItem.getBookId());
            orderItem.setBookInfo(bookInfo);
        }
        return list;
    }

    @Override
    public void updateStatus(Integer id, int status) {
        Order order = orderDao.findOrderById(id);
        order.setStatus(status);
        orderDao.updateOrder(order);
    }

    @Override
    public int update(Order order) {
        return orderDao.updateOrder(order);
    }

    @Override
    public int create(Order order) {
        return orderDao.insertOrder(order);
    }

    @Override
    public int deleteById(Integer id) {
        return orderDao.deleteOrder(id);
    }

    @Override
    public PageInfo<Order> findUserOrder(Integer userId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<Order> list = orderDao.findByUserId(userId);
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Order> pageinfo = new PageInfo<>(list);
        return pageinfo;
    }

    @Override
    public int pay(Integer orderId,Integer userId) {
        //具体逻辑就不实现了，直接更改状态为 待发货
        Order order = orderDao.findOrderById(orderId);
        User user = userDao.findUserById(userId);
        userDao.insertUser(user);
        if (order == null) {
            throw new RuntimeException("订单不存在");
        }
        return orderDao.updateStatus(STATE_WAITE_SEND,order.getId());
    }

    @Override
    public int submit(Integer userId, Integer addressId, List<Integer> cartIds)  {
        //生成订单
        Order order=new Order();
        //UUID生成随机的订单ID
        order.setId(RandomUtil.getRandomOrderId());
        order.setUserId(userId);
        order.setStatus(STATE_NO_PAY);
        order.setAddressId(addressId);
        order.setCreateTime(new Date());
        order.setDelete(false);
        //通过id的列表找到所有被选中的购物车项
        List<Cart> carts=cartDao.getCartListParams(cartIds);
        //订单金额和数量
        Double payment=0.0;
        //把购物车项形成orderItem
        for(Cart cart:carts){
            OrderItem orderItem=new OrderItem();
            orderItem.setBookId(cart.getBookId());
            orderItem.setBookInfo(bookInfoDao.findBookInfoById(cart.getBookId()));
            orderItem.setCount(cart.getBuyNum());
            orderItem.setOrderId(order.getId());
            orderItem.setSubPayment(cart.getSubTotal());
            //插入orderItem数据库
            orderItemDao.insertOrderItem(orderItem);
            payment+=cart.getSubTotal();
            //删除购物车项
            cartDao.deleteCart(cart.getId());
        }
        order.setPayment(payment);
        //插入order数据库
        return orderDao.insertOrder(order);
    }

    @Override
    public void receive(Integer orderId) {
        Order order = orderDao.findOrderById(orderId);
        if (order == null) {
            throw new RuntimeException("订单不存在！");
        }
        order.setStatus(STATE_COMPLETE);
        orderDao.updateOrder(order);
    }

    @Override
    public PageInfo<Order> getOrderList(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<Order> list = orderDao.getOrderListByParams();
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<Order> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int updateOrderByOrderNoAndPayNo(String out_trade_no, String trade_no) {
        return orderDao.updateOrderByOrderNoAndPayNo(out_trade_no, trade_no);
    }

    @Override
    public Order findByOrderNo(String out_trade_no) {
        return orderDao.findByOrderNo(out_trade_no);
    }

    @Override
    public List<CommentBookDto> getBookList(Integer orderId) {
        //获得订单
        Order order=orderDao.findOrderById(orderId);
        List<CommentBookDto> list=new ArrayList<>();
        List<OrderItem> orderItemList=orderItemDao.findByOrderId(orderId);
        for(OrderItem orderItem:orderItemList){
            CommentBookDto commentBookDto=new CommentBookDto();
            commentBookDto.setBookInfo(orderItem.getBookInfo());
            if(commentDao.getUserComment(order.getUserId(),orderItem.getBookId())!=null){
                commentBookDto.setIsComment(1);
            }else {
                commentBookDto.setIsComment(0);
            }
            list.add(commentBookDto);
        }
        return list;
    }
}
