package com.scutj2ee.bookstore.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/5 12:51
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CommentDaoTest {
    @Autowired
    private CommentDao commentDao;

    @Test
    public void getUserComment() {
        System.out.println(commentDao.getUserComment(1,1));
    }

    @Test
    public void getUserById() {
        commentDao.findCommentById(1);
    }

    @Test
    public void getCommentListByUserId() {
        commentDao.getCommentListByUserId(1);
    }
}