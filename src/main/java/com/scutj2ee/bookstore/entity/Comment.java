package com.scutj2ee.bookstore.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/1 15:36
 * @ Description：评论实体类
 * @ Modified By：
 */

public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**
     * 书本id
     */
    private Integer bookId;
    /**
     * 评论用户id
     */
    private Integer fromUid;
    /**
     * 评论内容
     */
    private String content;
    /**
     * 评论时间
     */
    private Date date;

    private User user;

    private BookInfo bookInfo;

    public Comment(){

    }

    public Comment(Integer id, Integer bookId, Integer fromUid, String content, Date date, User user, BookInfo bookInfo) {
        this.id = id;
        this.bookId = bookId;
        this.fromUid = fromUid;
        this.content = content;
        this.date = date;
        this.user = user;
        this.bookInfo = bookInfo;
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

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getFromUid() {
        return fromUid;
    }

    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", fromUid=" + fromUid +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}