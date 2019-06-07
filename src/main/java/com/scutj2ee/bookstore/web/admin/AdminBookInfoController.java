package com.scutj2ee.bookstore.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Address;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.model.dto.BookInfoDto;
import com.scutj2ee.bookstore.service.BookInfoService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author kobe
 * @Date 2019/5/25 16:44
 * @Description: 管理员对书籍的管理业务
 * @Modified By:
 */

@RestController
@RequestMapping("admin/bookInfo")
public class AdminBookInfoController {
    @Autowired
    private BookInfoService bookInfoService;

    /**
     * create by: Kobe
     * description:管理员查看所有书籍
     * create time: 14:12 2019/5/26
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public HashMap<String, Object> getBookInfoList(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        PageInfo<BookInfoDto> pageInfo = bookInfoService.getBookInfoList(pageNo,pageSize);
        resultMap.put("success",true);
        resultMap.put("msg","获取成功");
        resultMap.put("tableData",pageInfo == null ? null : pageInfo.getList() );
        resultMap.put("total", pageInfo == null ? null : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * create by: Kobe
     * description:管理员增加一本书籍
     * create time: 14:21 2019/5/26
     * @param request
     * @return
     */
    @PostMapping("/add")
    public HashMap<String, Object> addBookInfo(HttpServletRequest request) throws Exception{
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成BookInfo对象
        String bookInfoStr = HttpServletRequestUtil.getString(request, "bookInfo");
        ObjectMapper mapper = new ObjectMapper();
        BookInfo bookInfo = mapper.readValue(bookInfoStr, BookInfo.class);
        try {
            int result = bookInfoService.create(bookInfo);
            if(result > 0){
                resultMap.put("success",true);
                resultMap.put("msg","添加书籍成功");
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
     * description:管理员删除一个书籍
     * create time: 14:33 2019/5/26
     * @param request
     * @return
     */
    @DeleteMapping("/delete")
    public HashMap<String, Object> delBook(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        Integer bookInfoId = HttpServletRequestUtil.getInt(request,"bookInfoId");
        try {
            int result = bookInfoService.deleteById(bookInfoId);
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
     * description: 管理员更新一个书籍
     * create time: 14:39 2019/5/26
     * @param request
     * @return
     */
    @PostMapping("/update")
    public HashMap<String, Object> updateBookInfo(HttpServletRequest request) throws Exception{
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成BookInfo对象
        String bookInfoStr = HttpServletRequestUtil.getString(request, "bookInfo");
        ObjectMapper mapper = new ObjectMapper();
        BookInfo bookInfo = mapper.readValue(bookInfoStr, BookInfo.class);
        try {
            int result=bookInfoService.update(bookInfo);
            if (result>0) {
                resultMap.put("success", true);
                resultMap.put("msg", "修改书籍成功");
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
