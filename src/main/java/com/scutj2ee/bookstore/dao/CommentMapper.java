package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);
}