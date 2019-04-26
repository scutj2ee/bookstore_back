package com.scutj2ee.bookstore.entity;

import java.io.Serializable;

public class OrderItem implements Serializable {
    private Integer id;
    private Integer count;
    private Integer orderId;
    private Integer productId;
    private Integer subIntegral;
    private Double subTotal;

    private static final long serialVersionUID = 1L;

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

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getSubIntegral() {
        return subIntegral;
    }

    public void setSubIntegral(Integer subIntegral) {
        this.subIntegral = subIntegral;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
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
        sb.append(", count=").append(count);
        sb.append(", orderId=").append(orderId);
        sb.append(", productId=").append(productId);
        sb.append(", subIntegral=").append(subIntegral);
        sb.append(", subTotal=").append(subTotal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}