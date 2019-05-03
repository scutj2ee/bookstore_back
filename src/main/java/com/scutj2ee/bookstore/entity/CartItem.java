package com.scutj2ee.bookstore.entity;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/3 9:56
 * @ Description：购物项
 * @ Modified By：
 */
public class CartItem {
    private BookInfo bookInfo;

    private double subTotal;

    private int buyNum;

    private boolean checked = true;

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
