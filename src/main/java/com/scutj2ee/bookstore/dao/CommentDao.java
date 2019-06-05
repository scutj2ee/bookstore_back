package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentDao {
    int deleteComment(Integer commentId);

    int insertComment(Comment comment);

    Comment findCommentById(Integer commentId);

    List<Comment> selectAll(Integer bookId);

    int updateComment(Comment comment);

    List<Comment> getCommentListByBookId(Integer bookId);

    List<Comment> getCommentListByUserId(Integer userId);

    String getUserComment(@Param("fromUid")Integer fromUid,@Param("bookId") Integer bookId);
}