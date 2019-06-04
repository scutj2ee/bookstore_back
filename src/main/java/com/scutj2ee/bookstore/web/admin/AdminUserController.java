package com.scutj2ee.bookstore.web.admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.model.UserResult;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author kobe
 * @Date 2019/5/25 16:41
 * @Description: 后台管理员对用户管理的业务
 * @Modified By:
 */

@RestController
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private UserService userService;

    /**
     * create by: Kobe
     * description:管理员查看所有用户
     * create time: 21:34 2019/5/25
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public HashMap<String, Object> getUserList(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        PageInfo<User> pageInfo = userService.getUserList(pageNo,pageSize);
        resultMap.put("success",true);
        resultMap.put("msg","获取成功");
        resultMap.put("tableData",pageInfo == null ? null : pageInfo.getList() );
        resultMap.put("total", pageInfo == null ? null : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * create by: Kobe
     * description:管理员删除违规用户
     * create time: 21:44 2019/5/25
     * @param request
     * @return
     */
    @DeleteMapping("/delete")
    public HashMap<String, Object> delUser(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer userId;
        try {
            userId = HttpServletRequestUtil.getInt(request,"userId");
            int result = userService.deleteById(userId);
            if (result == 0) {
                resultMap.put("success", false);
                resultMap.put("msg", "删除失败");
            } else {
                resultMap.put("success", true);
                resultMap.put("msg","删除成功");
            }
        } catch (RuntimeException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }

    /**
     * @Author Bin Liu
     * @Description 管理员更新一个用户
     * @Date 2019/6/4 20:00
     * @param
     * @return
     */
    @PostMapping("/update")
    public HashMap<String, Object> updateOrder(HttpServletRequest request) throws Exception{
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成user对象
        String userStr = HttpServletRequestUtil.getString(request, "user");
        ObjectMapper mapper = new ObjectMapper();
        User user= mapper.readValue(userStr, User.class);
        try {
            UserResult userResult = userService.updateUser(user);
            resultMap.put("success", true);
            resultMap.put("code", userResult.getCode());
            resultMap.put("msg", userResult.getMsg());
            return resultMap;
        } catch (SystemException ex) {
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
            return resultMap;
        }
    }
}
