package com.scutj2ee.bookstore.web;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Comment;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.service.CommentService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author kobe
 * @Date 2019/5/22 12:29
 * @Description: 评论相关业务
 * @Modified By:
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
    public HashMap<String,Object> addComment(HttpServletRequest request, @RequestBody Comment comment) throws Exception{
        HashMap<String,Object> resultMap = new HashMap<>();
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
    @PutMapping("/update")
    public HashMap<String,Object> updateComment(HttpServletRequest request, @RequestBody Comment comment){
        HashMap<String,Object> resultMap = new HashMap<>();
        try{
            int result = commentService.updateComment(comment);
            if (result>0) {
                resultMap.put("success", true);
                resultMap.put("msg", "修改地址成功");
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

    /**
     * create by: Kobe
     * description:查看关于某本书的所有评论
     * create time: 15:06 2019/5/22
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("list")
    public HashMap<String, Object> selectAll(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer bookId;
        try {
            bookId = HttpServletRequestUtil.getInt(request, "bookId");
        } catch (NumberFormatException e) {
            resultMap.put("success", false);
            resultMap.put("msg", "获取书籍ID信息异常，无法完成注销。");
            return resultMap;
        }
        Map map = new HashMap();
        map.put("bookId", bookId);
        PageInfo<Comment> pageInfo = commentService.selectAll(map,pageNo,pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("tableData", pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? 0 : pageInfo.getTotal());
        return resultMap;
    }
}
