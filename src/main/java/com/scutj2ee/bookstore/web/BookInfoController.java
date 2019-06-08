package com.scutj2ee.bookstore.web;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Comment;
import com.scutj2ee.bookstore.model.dto.BookInfoDto;
import com.scutj2ee.bookstore.service.BookInfoService;
import com.scutj2ee.bookstore.service.CommentService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author: kevin
 * @data: 2019/5/17 12:47
 * @description:
 */
@RestController
@RequestMapping("/book")
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private CommentService commentService;

    /**
     * create by: Bin Liu
     * description: 获取具体商品信息
     * create time: 2019/6/4 10:10
     * @Param: null
     * @return
     */
    @RequestMapping("/info")
    public HashMap<String, Object> getBookInfo(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取前端传递的bookInfoId参数
        Integer bookInfoId = HttpServletRequestUtil.getInt(request, "bookInfoId");
        BookInfoDto bookInfoDto = bookInfoService.findById(bookInfoId);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("BookInfoDto", bookInfoDto);
        return resultMap;
    }

    /**
     * 获取最新的书
     * @return
     */
    @RequestMapping("/new")
    public HashMap<String, Object> getNewBook(Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        PageInfo<BookInfo> pageInfo = bookInfoService.findNewBook(pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("totalData", pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? null : pageInfo.getList());
        return resultMap;
    }

    /**
     * create by: Bin Liu
     * description: 通过一级类目id获取书本
     * create time: 2019/6/4 10:24
     * @Param: null
     * @return
     */
    @RequestMapping("/bookCategory")
    public HashMap<String, Object> getBookInfoByCategory(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer bookCategoryId = HttpServletRequestUtil.getInt(request, "bookCategoryId");
        PageInfo<BookInfo> pageInfo = bookInfoService.findByBookCategoryId(bookCategoryId, pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("totalData", pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? null : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * @Author Bin Liu
     * @Description 通过二级类目id获取书本
     * @Date 2019/6/4 16:19
     * @param 
     * @return 
     */
    @RequestMapping("/bookCategorySecond")
    public HashMap<String, Object> getBookInfoByCategorySecond(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer bookCategoryId = HttpServletRequestUtil.getInt(request, "BookCategoryId");
        PageInfo<BookInfo> pageInfo = bookInfoService.findByBookCategoryIdSecond(bookCategoryId, pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("totalData", pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? null : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * create by: Bin Liu
     * description: 获取所有商品
     * create time: 2019/6/4 10:10
     * @Param: null
     * @return
     */
    @RequestMapping("/all")
    public HashMap<String, Object> getAll(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        PageInfo<BookInfo> pageInfo= bookInfoService.getBookInfoList(pageNo,pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("tableData", pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? 0 : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * @Author: Bin Liu
     * @Description: 获取书本的评论
     * @Date: 2019/6/4 11:00
     * @Param:
     * @return:
     */
    @RequestMapping("/comment")
    public HashMap<String, Object> getBookInfoComment(HttpServletRequest request,Integer pageNo, Integer pageSize) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取前端传递的bookInfoId参数
        Integer bookInfoId = HttpServletRequestUtil.getInt(request, "bookInfoId");
        PageInfo<Comment> pageInfo = commentService.selectAll(bookInfoId, pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("tableData", pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? 0 : pageInfo.getTotal());
        return resultMap;
    }
}
