package com.scutj2ee.bookstore.model.dto;

import com.scutj2ee.bookstore.entity.BookInfo;

import java.io.Serializable;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/5 11:24
 * @ Description：已评论书本传输类
 * @ Modified By：
 */
public class CommentBookDto implements Serializable {
    private BookInfo bookInfo;
    /**
     * 1表示已评论 0表示未评论
     */
    private Integer isComment;

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Integer getIsComment() {
        return isComment;
    }

    public void setIsComment(Integer isComment) {
        this.isComment = isComment;
    }
}
