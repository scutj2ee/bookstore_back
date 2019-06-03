package com.scutj2ee.bookstore.entity;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/3 9:56
 * @ Description：购物项
 * @ Modified By：
 */
public class CartItem implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer cartId;

    private Integer bookId;

    @Transient
    private BookInfo bookInfo;

    private Double subTotal;

    private Integer buyNum;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public  CartItem(){}

    public CartItem(Integer id, Integer cartId, Integer bookId, BookInfo bookInfo, Double subTotal, Integer buyNum) {
        this.id = id;
        this.cartId = cartId;
        this.bookId = bookId;
        this.bookInfo = bookInfo;
        this.subTotal = subTotal;
        this.buyNum = buyNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
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
}
