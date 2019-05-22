package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.Comment;

import java.util.List;

/**
 * @Author kobe
 * @Date 2019/5/22 12:05
 * @Description:
 * @Modified By:
 */
public interface CommentService {
    /**
     * create by: Kobe
     * description:添加评论
     * create time: 12:07 2019/5/22
     * @param comment
     * @return int
     */
    int addComment(Comment comment);

    /**
     * create by: Kobe
     * description:删除评论
     * create time: 12:10 2019/5/22
     * @param commentId
     * @return int
     */
    int delComment(int commentId);

    /**
     * create by: Kobe
     * description:更新评论
     * create time: 12:13 2019/5/22
     * @param comment
     * @return
     */
    int updateComment(Comment comment);

    /**
     * create by: Kobe
     * description:获取评论列表
     * create time: 12:14 2019/5/22
     * @param
     * @return
     */
    List<Comment> selectAll(int bookId);
}
