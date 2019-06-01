package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Comment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface CommentDao {
    int deleteComment(Integer commentId);

    int insertComment(Comment comment);

    Comment findCommentById(Integer commentId);

    List<Comment> selectAll(Integer bookId);

    int updateComment(Comment comment);

    List<Comment> getCommentListByParams(Map map);
}