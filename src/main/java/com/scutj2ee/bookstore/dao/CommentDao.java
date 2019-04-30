package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Comment;

import java.util.List;

public interface CommentDao {
    int deleteComment(Integer commentId);

    int insertComment(Comment comment);

    Comment selectCommentById(Integer commentId);

    List<Comment> selectAll();

    int updateComment(Comment comment);
}