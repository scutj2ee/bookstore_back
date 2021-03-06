package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.BookInfoDao;
import com.scutj2ee.bookstore.dao.CommentDao;
import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Comment;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
    @Autowired
    private UserDao userDao;
    @Autowired
    private BookInfoDao bookInfoDao;

    @Override
    public int addComment(Comment comment) {
        comment.setDate(new Date());
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
    public PageInfo<Comment> selectAll(Integer bookId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<Comment> list = commentDao.getCommentListByBookId(bookId);
        for(Comment comment:list){
            comment.setUser(userDao.findUserById(comment.getFromUid()));
            comment.setBookInfo(bookInfoDao.findBookInfoById(comment.getBookId()));
        }
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Comment findCommentById(int commentId) {
        return commentDao.findCommentById(commentId);
    }

    @Override
    public PageInfo<Comment> selectAllByUerId(Integer userId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<Comment> list = commentDao.getCommentListByUserId(userId);
        for(Comment comment:list){
            User user=userDao.findUserById(comment.getFromUid());
            comment.setUser(user);
            BookInfo bookInfo=bookInfoDao.findBookInfoById(comment.getBookId());
            comment.setBookInfo(bookInfo);
        }
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Comment> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
