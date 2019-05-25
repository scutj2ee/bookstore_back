package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Comment;

import java.util.Map;

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
     * @param map
     * @param pageNo
     * @return
     */
    PageInfo<Comment> selectAll(Map map, Integer pageNo, Integer pageSize);

    /**
     * create by: Kobe
     * description:根据id找评论接口
     * create time: 14:59 2019/5/22
     * @param commentId
     * @return
     */
    Comment findCommentById(int commentId);
}
