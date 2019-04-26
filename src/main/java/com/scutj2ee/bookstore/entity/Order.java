package com.scutj2ee.bookstore.entity;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private Integer id;
    private Integer addressId;
    private Date orderTime;
    private Integer state;
    private Double total;
    private Integer totalIntegral;
    private Integer userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getTotalIntegral() {
        return totalIntegral;
    }

    public void setTotalIntegral(Integer totalIntegral) {
        this.totalIntegral = totalIntegral;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", addressId=").append(addressId);
        sb.append(", orderTime=").append(orderTime);
        sb.append(", state=").append(state);
        sb.append(", total=").append(total);
        sb.append(", totalIntegral=").append(totalIntegral);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}