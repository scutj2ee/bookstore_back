package com.scutj2ee.bookstore.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.service.BookCategoryService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author kobe
 * @Date 2019/5/25 16:45
 * @Description: 管理员对书籍类别业务
 * @Modified By: Liu Bin
 */

@RestController
@RequestMapping("/admin/bookCategory")
public class AdminBookCategoryController {
    @Autowired
    private BookCategoryService bookCategoryService;

    /**
     * create by: Kobe
     * description:管理员按照类别查看所有书籍类别
     * create time: 14:12 2019/5/26
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public HashMap<String, Object> getBookCategoryList(HttpServletRequest request, Integer type,Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        PageInfo<BookCategory> pageInfo = bookCategoryService.findByType(type,pageNo,pageSize);
        resultMap.put("success",true);
        resultMap.put("msg","获取成功");
        resultMap.put("tableData",pageInfo == null ? null : pageInfo.getList() );
        resultMap.put("total", pageInfo == null ? null : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * create by: Kobe
     * description:管理员增加一个书类
     * create time: 14:21 2019/5/26
     * @param request
     * @return
     */
    @PostMapping("/add")
    public HashMap<String, Object> addBookCategory(HttpServletRequest request ) throws Exception{
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成bookCategory对象
        String bookCategoryStr = HttpServletRequestUtil.getString(request, "bookCategory");
        ObjectMapper mapper = new ObjectMapper();
        BookCategory bookCategory = mapper.readValue(bookCategoryStr, BookCategory.class);
        try {
            int result = bookCategoryService.create(bookCategory);
            if(result > 0){
                resultMap.put("success",true);
                resultMap.put("msg","添加书类成功");
            } else{
                resultMap.put("success",false);
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
     * description:管理员删除一个书类
     * create time: 14:33 2019/5/26
     * @param request
     * @return
     */
    @DeleteMapping("/delete")
    public HashMap<String, Object> delBook(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        Integer bookCategoryId = HttpServletRequestUtil.getInt(request,"bookCategoryId");
        try {
            int result = bookCategoryService.deleteById(bookCategoryId);
            if (result == 0) {
                resultMap.put("success", false);
                resultMap.put("msg", "删除失败");
            } else {
                resultMap.put("success", true);
                resultMap.put("msg", "删除成功");
            }
        } catch (RuntimeException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * create by: Kobe
     * description: 管理员更新一个书类
     * create time: 14:39 2019/5/26
     * @param request
     * @param bookCategory
     * @return
     */
    @PostMapping("/update")
    public HashMap<String, Object> updateBookCategory(HttpServletRequest request, @RequestBody BookCategory bookCategory) throws Exception{
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int result=bookCategoryService.update(bookCategory);
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
}
