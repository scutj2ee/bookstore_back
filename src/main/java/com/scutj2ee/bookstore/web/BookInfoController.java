package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.pojo.ResultBean;
import com.scutj2ee.bookstore.service.AddressService;
import com.scutj2ee.bookstore.service.BookCategoryService;
import com.scutj2ee.bookstore.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author: kevin
 * @data: 2019/5/17 12:47
 * @description:
 */
@RequestMapping("/book")
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private AddressService addressService;


    /**
     * 商品详情页面
     * 等到具体的接口定好，再修改
     */
    @RequestMapping("/getinformation")
    public String toBookInfoPage(Integer id, Map<String, Object> map){
        BookInfo bookInfo = bookInfoService.findById(id);
        map.put("bookInfo", bookInfo);
        return "/Book/info";
    }

    /**
     * 获取书的信息
     */
    @RequestMapping("/get")
    public ResultBean<BookInfo> getProduct(Integer id){
        BookInfo bookInfo = bookInfoService.findById(id);
        return new ResultBean<>(bookInfo);
    }

    /**
     *
     */
}
