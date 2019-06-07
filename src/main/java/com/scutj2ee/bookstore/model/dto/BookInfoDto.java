package com.scutj2ee.bookstore.model.dto;

import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Comment;

import java.io.Serializable;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/7 16:44
 * @ Description：用于存放书及其相关的评论
 * @ Modified By：
 */
public class BookInfoDto implements Serializable {
    private BookInfo bookInfo;
    private List<CommentDto> commentDtoList;

    public BookInfo getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public List<CommentDto> getCommentDtoList() {
        return commentDtoList;
    }

    public void setCommentDtoList(List<CommentDto> commentDtoList) {
        this.commentDtoList = commentDtoList;
    }
}
