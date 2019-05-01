package com.scutj2ee.bookstore.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/1 15:36
 * @ Description：订单实体类
 * @ Modified By：
 */

public class Order implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 实付金额。精确到2位小数;单位:元。如:200.07，表示:200元7分
     */
    private Double payment;
    /**
     * 支付状态 0未支付 1已支付
     */
    private Integer status;
    /**
     * 订单地址
     */
    private Integer addressId;
    /**
     * 订单创建时间
     */
    private Date createTime;
    /**
     * 交易完成时间
     */
    private Date endTime;
    /**
     * 订单积分
     */
    private Integer totalIntegral;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
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

    public Integer getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalIntegral(Integer totalIntegral) {
        this.totalIntegral = totalIntegral;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", payment=" + payment +
                ", status=" + status +
                ", addressId=" + addressId +
                ", createTime=" + createTime +
                ", endTime=" + endTime +
                ", totalIntegral=" + totalIntegral +
                '}';
    }
}