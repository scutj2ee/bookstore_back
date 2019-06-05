package com.scutj2ee.bookstore.entity;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/1 15:36
 * @ Description：订单详情实体类
 * @ Modified By：
 */


public class OrderItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 售货数量
     */
    private Integer count;
    /**
     * 书本id
     */
    private Integer bookId;
    /**
     * 价格
     */
    private Double subPayment;

    @Transient
    private BookInfo bookInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Double getSubPayment() {
        return subPayment;
    }

    public void setSubPayment(Double subPayment) {
        this.subPayment = subPayment;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", count=" + count +
                ", bookId=" + bookId +
                ", subPayment=" + subPayment +
                '}';
    }
}