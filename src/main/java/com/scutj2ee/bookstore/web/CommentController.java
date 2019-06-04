package com.scutj2ee.bookstore.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scutj2ee.bookstore.entity.Comment;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.service.CommentService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author kobe
 * @Date 2019/5/22 12:29
 * @Description: 评论相关业务
 * @Modified By: Liu Bin
 */
@RestController
@RequestMapping("comment")
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
    @PostMapping("/add")
    public HashMap<String,Object> addComment(HttpServletRequest request) throws Exception{
        HashMap<String,Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成Comment对象
        String commentStr = HttpServletRequestUtil.getString(request, "comment");
        ObjectMapper mapper = new ObjectMapper();
        Comment comment = mapper.readValue(commentStr, Comment.class);
        try {
            int result = commentService.addComment(comment);
            if (result>0) {
                resultMap.put("success", true);
                resultMap.put("msg", "增加地址成功");
            } else {
                resultMap.put("success", false);
            }
            return resultMap;
        } catch (SystemException ex){
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
            return resultMap;
        }
    }

    /**
     * create by: Kobe
     * description:删除评论
     * create time: 14:54 2019/5/22
     * @param request
     * @return
     */
    @DeleteMapping("delete")
    public HashMap<String,Object> delComment(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        try {
            int result = commentService.delComment(HttpServletRequestUtil.getInt(request,"commentId"));
            if (result>0) {
                resultMap.put("success", true);
                resultMap.put("msg", "删除评论成功");
            } else {
                resultMap.put("success", false);
            }
            return resultMap;
        } catch (SystemException ex){
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
            return resultMap;
        }
    }

    /**
     * create by: Kobe
     * description:修改评论
     * create time: 14:56 2019/5/22
     * @param request
     * @return
     */
    @PostMapping("/update")
    public HashMap<String,Object> updateComment(HttpServletRequest request, @RequestBody Comment comment){
        HashMap<String,Object> resultMap = new HashMap<>();
        try{
            int result = commentService.updateComment(comment);
            if (result>0) {
                resultMap.put("success", true);
                resultMap.put("msg", "修改评论成功");
            } else {
                resultMap.put("success", false);
            }
            return resultMap;
        } catch (SystemException ex) {
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
            return resultMap;
        }
    }
}
