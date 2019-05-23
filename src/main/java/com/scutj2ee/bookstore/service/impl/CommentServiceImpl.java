package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.CommentDao;
import com.scutj2ee.bookstore.entity.Comment;
import com.scutj2ee.bookstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author kobe
 * @Date 2019/5/22 12:16
 * @Description:
 * @Modified By:
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;

    @Override
    public int addComment(Comment comment) {
        return commentDao.insertComment(comment);
    }

    @Override
    public int delComment(int commentId) {
        return commentDao.deleteComment(commentId);
    }

    @Override
    public int updateComment(Comment comment) {
        return commentDao.updateComment(comment);
    }

    @Override
    public List<Comment> selectAll(int bookId) {
        return commentDao.selectAll(bookId);
    }

    @Override
    public Comment findCommentById(int commentId) {
        return commentDao.findCommentById(commentId);
    }
}
