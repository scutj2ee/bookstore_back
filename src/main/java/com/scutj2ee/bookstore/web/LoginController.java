package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.LoginResultEnum;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.model.LoginResult;
import com.scutj2ee.bookstore.service.LoginService;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
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

    /**
     * create by: Bin Liu
     * description: 用户登录
     * create time: 2019/5/4 10:05
     * @Param: null
     * @return
     */
    @PostMapping("/user/login")
    private HashMap<String, Object> loginByUser(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.根据前端传递的参数发起登录请求
        String username = HttpServletRequestUtil.getString(request, "name");
        String password = HttpServletRequestUtil.getString(request, "password");
        try {
            LoginResult result = loginService.loginByUser(username, password);
            if (result.getCode().equals(LoginResultEnum.SUCCESS.getCode())) {
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
                //如果userList已经存在
                if (null != request.getSession().getAttribute("userList")) {
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

    /**
     * create by: Bin Liu
     * description: 管理员登录
     * create time: 2019/5/4 10:05
     * @Param: null
     * @return
     */
    @PostMapping("/admin/login")
    private HashMap<String, Object> loginByAdmin(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.根据前端传递的参数发起登录请求,默认字符串是进行了去空处理
        String username = HttpServletRequestUtil.getString(request, "name");
        String password = HttpServletRequestUtil.getString(request, "password");
        try {
            LoginResult result = loginService.loginByAdmin(username, password);
            if (result.getCode().equals(LoginResultEnum.SUCCESS.getCode())) {
                resultMap.put("success", true);
                //将管理员信息返回给前端之后需要使用
                resultMap.put("admin", result.getUser());
            } else {
                resultMap.put("success", false);
            }
            resultMap.put("code", result.getCode());
            resultMap.put("msg", result.getMsg());
            //将管理员信息存入session中
            if (result.getUser() != null) {
                List<User> adminList = new ArrayList<>();
                //如果adminList已经存在
                if (null != request.getSession().getAttribute("adminList")) {
                    adminList = (List<User>) request.getSession().getAttribute("adminrList");
                }
                //添加user到 userList
                adminList.add(result.getUser());
                request.getSession().setAttribute("adminList", adminList);
            }
        } catch (LoginException ex) {
            resultMap.put("success", false);
            resultMap.put("msg", ex.getMessage());
            resultMap.put("code", ex.getCode());
        }
        return resultMap;
    }

    /**
     * create by: Bin Liu
     * description: 用户登出
     * create time: 2019/5/4 10:06
     * @Param: null
     * @return
     */
    @GetMapping("/user/logout")
    private HashMap<String, Object> logout(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //获取要logout的用户id
        int userId;
        try {
            userId = Integer.parseInt(HttpServletRequestUtil.getString(request, "userId"));
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
            boolean loginYes=false;
            if (userList != null) {
                //在userList中找到那个要登出的用户
                for (User oneUser : userList) {
                    if (//id、姓名、部门都相同
                            oneUser.getId().equals(user.getId()) &&
                                    oneUser.getUsername().equals(user.getUsername())) {
                        //确实已经登录
                        loginYes =true;
                        userToRemove = oneUser;
                    }
                }
                //服务器未检测到该用户已登录
                if(loginYes ==false) {
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

    /**
     * create by: Bin Liu
     * description: 管理员登出
     * create time: 2019/5/4 10:07
     * @Param: null
     * @return
     */
    @GetMapping("/admin/logout")
    private HashMap<String, Object> adminlogout(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //获取要logout的 admin用户id
        int adminId;
        try {
            adminId = Integer.parseInt(HttpServletRequestUtil.getString(request, "adminId"));
        } catch (NumberFormatException e) {
            resultMap.put("success", false);
            resultMap.put("msg", "获取管理员对象ID信息异常，无法完成注销。");
            return resultMap;
        }
        //开始尝试注销
        HttpSession session = request.getSession();
        List<User> adminList= (List<User>) session.getAttribute("adminList");
        boolean loginYes=false;
        try {
            User admin = userService.getUserById(adminId);
            User adminToRemove=null;
            if (adminList != null) {
                //在老列表里面比对，得到新的已登录列表
                for (User oneAdmin : adminList) {
                    //id、姓名都相同
                    if (
                            oneAdmin.getId().equals(admin.getId()) &&
                                    oneAdmin.getUsername().equals(admin.getUsername())
                            ) {
                        //确实已经登录
                        loginYes=true;
                        adminToRemove=oneAdmin;
                    }
                }
                //服务器未检测到该用户已登录
                if(loginYes ==false) {
                    resultMap.put("success", false);
                    resultMap.put("msg", "服务器未检测到该用户已登录！");
                    return resultMap;
                }
                //注销
                adminList.remove(adminToRemove);
            }
            //更新已登录用户列表
            session.setAttribute("adminList", adminList);
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
