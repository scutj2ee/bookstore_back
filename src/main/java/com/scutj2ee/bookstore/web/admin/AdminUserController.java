package com.scutj2ee.bookstore.web.admin;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    public HashMap<String, Object> delUSer(HttpServletRequest request){
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
}
