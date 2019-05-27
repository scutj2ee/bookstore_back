
package com.scutj2ee.bookstore.web;

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
     * 根据父节点查询商品类目
     * @param request
     * @return
     */
    @GetMapping("/list")
    public HashMap<String, Object> getCategoryById(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer cateId;
        try{
            cateId = HttpServletRequestUtil.getInt(request, "cateId");
        }catch (NumberFormatException e){
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID异常");
            return resultMap;
        }
        BookCategory bookCategory = bookCategoryService.findById(cateId);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("BookCategory", bookCategory);
        return resultMap;
    }

    /**
     * 保存
     * @param request
     * @param bookCategory
     * @return
     */
    @PostMapping
    public HashMap<String, Object> saveCategory(HttpServletRequest request, @RequestBody BookCategory bookCategory)throws Exception{
        HashMap<String, Object> resultMap = new HashMap<>();
        try{
            int result = bookCategoryService.create(bookCategory);
            if(result>0){
                resultMap.put("success", true);
                resultMap.put("msg", "保存成功");
            }else {
                resultMap.put("success", false);
            }
            return resultMap;
        }catch (SystemException ex){
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
            return resultMap;
        }
    }


    /**
     * 更新
     * @param request
     * @param bookCategory
     * @return
     * @throws Exception
     */
    @PutMapping("/updateCategory")
    public HashMap<String, Object> updateCategory(HttpServletRequest request, @RequestBody BookCategory bookCategory)throws Exception{
        HashMap<String, Object> resultMap = new HashMap<>();
        try{
            int result = bookCategoryService.update(bookCategory);
            if(result>0){
                resultMap.put("success", true);
                resultMap.put("msg", "保存成功");
            }else {
                resultMap.put("success", false);
            }
            return resultMap;
        }catch (SystemException ex){
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
            return resultMap;
        }
    }

    /**
     * 删除
     * @return
     */
    @DeleteMapping("/deleteCategory")
    public HashMap<String, Object> deleteCategory(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer bookCategoryId = HttpServletRequestUtil.getInt(request, "bookCategoryId");
        try {
            int result = bookCategoryService.deleteById(bookCategoryId);
            if(result==0){
                resultMap.put("success", false);
                resultMap.put("msg", "删除失败");
            }else {
                resultMap.put("success", true);
                resultMap.put("msg", "删除失败");
            }
        }catch (RuntimeException e){
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * 根据分类id集合查询分类名称
     * @param request
     * @return
     */
    @RequestMapping("/names")
    public HashMap<String, Object> getCategoryName(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer bookCategoryId;
        try{
            bookCategoryId = HttpServletRequestUtil.getInt(request, "bookCategoryId");
        }catch (NumberFormatException e){
            resultMap.put("success", false);
            resultMap.put("msg", "获取对象ID信息异常");
            return resultMap;
        }
        BookCategory bookCategory = bookCategoryService.findById(bookCategoryId);
        String name = bookCategory.getName();
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("name", name);
        return resultMap;
    }

    /**
     * 根据以及分类查询二级分类
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/getCategorySec")
    public HashMap<String, Object> getCategorySec(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer categoryParentId;
        try{
            categoryParentId = HttpServletRequestUtil.getInt(request, "parentId");
        }catch (NumberFormatException e){
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID信息异常");
            return resultMap;
        }
        PageInfo<BookCategory> pageInfo = bookCategoryService.findByParentId(categoryParentId, pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("totallData", pageInfo==null?null:pageInfo.getList());
        return resultMap;
    }
}


