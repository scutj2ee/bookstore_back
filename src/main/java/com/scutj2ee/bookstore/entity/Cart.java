package com.scutj2ee.bookstore.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/3 9:56
 * @ Description： 购物车实体类
 * @ Modified By：
 */
public class Cart implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userId;

    private Integer bookId;

    @Transient
    private BookInfo bookInfo;

    private Double subTotal;

    private Integer buyNum;

    public Cart() {
    }

    public Cart(Integer id, Integer userId, Integer bookId, BookInfo bookInfo, Double subTotal, Integer buyNum) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.bookInfo = bookInfo;
        this.subTotal = subTotal;
        this.buyNum = buyNum;
    }

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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", userId=" + userId +
                ", bookId=" + bookId +
                ", bookInfo=" + bookInfo +
                ", subTotal=" + subTotal +
                ", buyNum=" + buyNum +
                '}';
    }
}
