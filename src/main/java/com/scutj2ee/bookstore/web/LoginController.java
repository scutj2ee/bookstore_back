package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.AdminUser;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.LoginResultEnum;
import com.scutj2ee.bookstore.exception.CustomUnauthorizedException;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.model.LoginResult;
import com.scutj2ee.bookstore.model.common.Constant;
import com.scutj2ee.bookstore.model.common.ResponseBean;
import com.scutj2ee.bookstore.service.AdminUserService;
import com.scutj2ee.bookstore.service.LoginService;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/3 9:45
 * @ Description：登陆控制器类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;
    @Autowired
    private AdminUserService adminUserService;

    @PostMapping("/user/login")
    private HashMap<String, Object> loginByUser(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.根据前端传递的参数发起登录请求
        String username = HttpServletRequestUtil.getString(request, "username");
        String password = HttpServletRequestUtil.getString(request, "password");
        try {
            LoginResult result = loginService.loginByUser(username, password);
            if (result.getCode().intValue() == LoginResultEnum.SUCCESS.getCode().intValue()) {
                resultMap.put("success", true);
                //将user返回给前端之后需要使用
                resultMap.put("user", result.getUser());
            } else {
                resultMap.put("success", false);
            }
            resultMap.put("code", result.getCode());
            resultMap.put("msg", result.getMsg());
            //将用户信息存入session中
            if (result.getUser() != null) {
                List<User> userList = new ArrayList<>();
                if (null != request.getSession().getAttribute("userList")) {
                    //如果userList已经存在
                    userList = (List<User>) request.getSession().getAttribute("userList");
                }
                //添加user到 userList
                userList.add(result.getUser());
                request.getSession().setAttribute("userList", userList);
            }
        } catch (LoginException ex) {
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/adminUser/login")
    private HashMap<String, Object> loginByAdminUser(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.根据前端传递的参数发起登录请求,默认字符串是进行了去空处理
        String username = HttpServletRequestUtil.getString(request, "username");
        String password = HttpServletRequestUtil.getString(request, "password");
        try {
            LoginResult result = loginService.loginByAdminUser(username, password);
            if (result.getCode().intValue() == LoginResultEnum.SUCCESS.getCode().intValue()) {
                resultMap.put("success", true);
                //将管理员信息返回给前端之后需要使用
                resultMap.put("adminUser", result.getAdminUser());
            } else {
                resultMap.put("success", false);
            }
            resultMap.put("code", result.getCode());
            resultMap.put("msg", result.getMsg());
            //将管理员信息存入session中
            if (result.getAdminUser() != null) {
                List<AdminUser> adminUserList = new ArrayList<>();
                if (null != request.getSession().getAttribute("adminUserList")) {
                    //如果adminUserList已经存在
                    adminUserList = (List<AdminUser>) request.getSession().getAttribute("adminUserList");
                }
                //添加adminUser到 adminUserList
                adminUserList.add(result.getAdminUser());
                request.getSession().setAttribute("adminUserList", adminUserList);
            }
        } catch (LoginException ex) {
            resultMap.put("success", false);
            resultMap.put("msg", ex.getMessage());
            resultMap.put("code", ex.getCode());
        }
        return resultMap;
    }

    @GetMapping("/user/logout")
    private HashMap<String, Object> logout(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //获取要logout的用户id
        Integer userId;
        try {
            userId = HttpServletRequestUtil.getInt(request, "userId");
        } catch (NumberFormatException e) {
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID信息异常，无法完成注销。");
            return resultMap;
        }
        //开始尝试注销
        try {
            User user = userService.getUserById(userId);
            User userToRemove = null;
            HttpSession session = request.getSession();
            List<User> userList = (List<User>) session.getAttribute("userList");
            boolean loginYes = false;
            if (userList != null) {
                for (User oneUser : userList) {
                    //在userList中找到那个要登出的用户
                    if (//id、姓名都相同
                            oneUser.getId().equals(user.getId()) &&
                                    oneUser.getUsername().equals(user.getUsername())) {
                        //确实已经登录
                        loginYes = true;
                        userToRemove = oneUser;
                    }
                }
                //服务器未检测到该用户已登录
                if (loginYes == false) {
                    resultMap.put("success", false);
                    resultMap.put("msg", "服务器未检测到该用户已登录！");
                    return resultMap;
                }
                //注销
                userList.remove(userToRemove);
            }
            //更新已登录用户列表
            session.setAttribute("userList", userList);
            resultMap.put("success", true);
            resultMap.put("msg", "注销成功！");
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("success", false);
            resultMap.put("msg", "注销过程中发生异常！");
            return resultMap;
        }
    }

    @GetMapping("/adminUser/logout")
    private HashMap<String, Object> adminUserLogout(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //获取要logout的 adminUser用户id
        int adminUserId;
        try {
            adminUserId = HttpServletRequestUtil.getInt(request, "adminUserId");
        } catch (NumberFormatException e) {
            resultMap.put("success", false);
            resultMap.put("msg", "获取管理员对象ID信息异常，无法完成注销。");
            return resultMap;
        }
        //开始尝试注销
        HttpSession session = request.getSession();
        List<AdminUser> adminUserList = (List<AdminUser>) session.getAttribute("adminUserList");
        boolean loginYes = false;
        try {
            AdminUser adminUser= adminUserService.getAdminUserById(adminUserId);
            AdminUser adminUserToRemove = null;
            if (adminUserList != null) {
                for (AdminUser oneAdminUser : adminUserList) {
                    //在老列表里面比对，得到新的已登录列表
                    if (//id、姓名都相同
                            oneAdminUser.getId().equals(adminUser.getId()) &&
                                    oneAdminUser.getUsername().equals(adminUser.getUsername()) ) {
                        //确实已经登录
                        loginYes = true;
                        adminUserToRemove = oneAdminUser;
                    }
                }
                //服务器未检测到该用户已登录
                if (loginYes == false) {
                    resultMap.put("success", false);
                    resultMap.put("msg", "服务器未检测到该管理员已登录！");
                    return resultMap;
                }
                //注销
                adminUserList.remove(adminUserToRemove);
            }
            //更新已登录用户列表
            session.setAttribute("adminUserList", adminUserList);
            resultMap.put("success", true);
            resultMap.put("msg", "注销成功！");
            return resultMap;
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("success", false);
            resultMap.put("msg", "注销过程中发生异常！");
            return resultMap;
        }
    }
}
