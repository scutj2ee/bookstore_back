package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.Comment;
import com.scutj2ee.bookstore.service.CommentService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author kobe
 * @Date 2019/5/22 12:29
 * @Description: 评论相关业务
 * @Modified By:
 */
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * create by: Kobe
     * description:添加评论
     * create time: 12:31 2019/5/22
     * @param request
     * @return
     */
    public int addComment(HttpServletRequest request){
        Comment comment = new Comment();
        comment.setBookId(HttpServletRequestUtil.getInt(request,"bookId"));
        comment.setContent(HttpServletRequestUtil.getString(request,"content"));
        comment.setDate(HttpServletRequestUtil.getDate(request,"date"));
        comment.setFromUid(HttpServletRequestUtil.getInt(request,"userId"));
        return commentService.addComment(comment);
    }

    /**
     * create by: Kobe
     * description:删除评论
     * create time: 14:54 2019/5/22
     * @param request
     * @return
     */
    public int delComment(HttpServletRequest request){
        return commentService.delComment(HttpServletRequestUtil.getInt(request,"commentId"));
    }

    /**
     * create by: Kobe
     * description:修改评论
     * create time: 14:56 2019/5/22
     * @param request
     * @return
     */
    public int updateComment(HttpServletRequest request){
        Comment comment = commentService.findCommentById(HttpServletRequestUtil.getInt(request,"commentId"));
        comment.setContent(HttpServletRequestUtil.getString(request,"content"));
        comment.setDate(HttpServletRequestUtil.getDate(request,"date"));
        return commentService.updateComment(comment);
    }

    /**
     * create by: Kobe
     * description:查看关于某本书的所有评论
     * create time: 15:06 2019/5/22
     * @param request
     * @return
     */
    public List<Comment> selectAll(HttpServletRequest request){
        return commentService.selectAll(HttpServletRequestUtil.getInt(request,"bookId"));
    }

}
