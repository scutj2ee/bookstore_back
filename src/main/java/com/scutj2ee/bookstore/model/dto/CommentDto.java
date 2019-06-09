package com.scutj2ee.bookstore.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/7 20:59
 * @ Description：评论传输类
 * @ Modified By：
 */
public class CommentDto implements Serializable {
    private String username;
    private Date date;
    private String content;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
