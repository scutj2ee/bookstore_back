package com.scutj2ee.bookstore.web;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.entity.BookInfo;

import com.scutj2ee.bookstore.service.AddressService;
import com.scutj2ee.bookstore.service.BookCategoryService;
import com.scutj2ee.bookstore.service.BookInfoService;
import com.scutj2ee.bookstore.service.CartService;
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
    private BookCategoryService bookCategoryService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CartService cartService;

    /**
     * 获取商品信息
     * @param
     * @return
     */
    @RequestMapping("/get")
    public HashMap<String, Object> getBookInfo(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer bookInfoId;
        try{
            bookInfoId = HttpServletRequestUtil.getInt(request, "bookInfoId");
        }catch (NumberFormatException e){
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID信息异常！");
            return resultMap;
        }
        BookInfo bookInfo = bookInfoService.findById(bookInfoId);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("BookInfo", bookInfo);
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
     * 通过书的类别来查找书
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/bookCategory")
    public HashMap<String, Object> getBookInfoByCategory(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer bookCategoryId;
        try{
            bookCategoryId = HttpServletRequestUtil.getInt(request, "BookCategoryId");
        }catch (NumberFormatException e){
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID信息异常");
            return resultMap;
        }
        PageInfo<BookInfo> pageInfo = bookInfoService.findByBookCategoryId(bookCategoryId, pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("totalData", pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? null : pageInfo.getList());
        return resultMap;
    }



}
