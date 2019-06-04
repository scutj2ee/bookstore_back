
package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/23 15:42
 * @ Description：书本种类控制类
 * @ Modified By：
 */
@RestController
@RequestMapping("category")
public class BookCategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;

    /**
     * @Author: Bin Liu
     * @Description: 获取所有的书本类目
     * @Date: 2019/6/4 10:55
     * @Param: 
     * @return: 
     */
    @GetMapping("/list")
    public HashMap<String, Object> getCategoryById(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        List<BookCategory> bookCategoryList = bookCategoryService.findAll();
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("bookCategoryList", bookCategoryList);
        return resultMap;
    }
}


