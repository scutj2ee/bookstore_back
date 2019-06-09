package com.scutj2ee.bookstore.model.dto;

import com.scutj2ee.bookstore.entity.Address;
import com.scutj2ee.bookstore.entity.BookInfo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/9 20:21
 * @ Description：订单传输类
 * @ Modified By：
 */
public class OrderDto implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 金额
     */
    private Double payment;
    /**
     * 支付状态 1未支付 2等待发货 3等待收货 4订单完成 5已评价
     */
    private Integer status;
    /**
     * 订单地址
     */
    private Address address;
    /**
     * 订单创建时间
     */
    private Date createTime;
    /**
     * 交易完成时间
     */
    private Date endTime;
    /**
     * 1级类目对应的2级类目
     */
    private List<BookInfo> bookInfoList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<BookInfo> getBookInfoList() {
        return bookInfoList;
    }

    public void setBookInfoList(List<BookInfo> bookInfoList) {
        this.bookInfoList = bookInfoList;
    }
}
