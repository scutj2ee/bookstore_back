package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.LoginResultEnum;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.pojo.LoginResult;
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
 * @ Description：${description}
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private UserService userService;

    //用户登录
    @PostMapping("/user/login")
    private HashMap<String, Object> loginByUser(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.根据前端传递的参数发起登录请求
        String departmentName = HttpServletRequestUtil.getString(request, "departmentName");
        String name = HttpServletRequestUtil.getString(request, "name");
        String password = HttpServletRequestUtil.getString(request, "password");
        try {
            LoginResult result = loginService.loginByUser(name, password);
            if (result.getCode() == LoginResultEnum.SUCCESS.getCode()) {
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
                if (null != request.getSession().getAttribute("userList")) {//如果userList已经存在
                    userList = (List<User>) request.getSession().getAttribute("userList");
                }
                userList.add(result.getUser());//添加user到 userList
                request.getSession().setAttribute("userList", userList);
            }
        } catch (LoginException ex) {
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
        }
        return resultMap;
    }

    //管理员登录
    @PostMapping("/admin/login")
    private HashMap<String, Object> loginByAdmin(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.根据前端传递的参数发起登录请求,默认字符串是进行了去空处理
        String departmentName = HttpServletRequestUtil.getString(request, "departmentName");
        String name = HttpServletRequestUtil.getString(request, "name");
        String password = HttpServletRequestUtil.getString(request, "password");
        try {
            LoginResult result = loginService.loginByAdmin(name, password);
            if (result.getCode() == LoginResultEnum.SUCCESS.getCode()) {
                resultMap.put("success", true);
                //将管理员信息返回给前端之后需要使用
                resultMap.put("admin", result.getManager());
            } else {
                resultMap.put("success", false);
            }
            resultMap.put("code", result.getCode());
            resultMap.put("msg", result.getMsg());
            //将管理员信息存入session中
            if (result.getManager() != null) {
                List<User> managerList = new ArrayList<>();
                if (null != request.getSession().getAttribute("managerList")) {//如果managerList已经存在
                    managerList = (List<User>) request.getSession().getAttribute("managerList");
                }
                managerList.add(result.getManager());//添加user到 userList
                request.getSession().setAttribute("adminList", managerList);
            }
        } catch (LoginException ex) {
            resultMap.put("success", false);
            resultMap.put("msg", ex.getMessage());
            resultMap.put("code", ex.getCode());
        }
        return resultMap;
    }

    //用户登出
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
                for (User oneUser : userList) {//在userList中找到那个要登出的用户
                    if (//id、姓名、部门都相同
                            oneUser.getId().equals(user.getId()) &&
                                    oneUser.getUsername().equals(user.getUsername())) {
                        loginYes =true;//确实已经登录
                        userToRemove = oneUser;
                    }
                }
                if(loginYes ==false) {//服务器未检测到该用户已登录
                    resultMap.put("success", false);
                    resultMap.put("msg", "服务器未检测到该用户已登录！");
                    return resultMap;
                }
                userList.remove(userToRemove);//注销
            }
            session.setAttribute("userList", userList);//更新已登录用户列表
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

    //管理员登出
    @GetMapping("/admin/logout")
    private HashMap<String, Object> adminlogout(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //获取要logout的 manager用户id
        int managerId;
        try {
            managerId = Integer.parseInt(HttpServletRequestUtil.getString(request, "managerId"));
        } catch (NumberFormatException e) {
            resultMap.put("success", false);
            resultMap.put("msg", "获取管理员对象ID信息异常，无法完成注销。");
            return resultMap;
        }
        //开始尝试注销
        HttpSession session = request.getSession();
        List<Manager> managerList= (List<Manager>) session.getAttribute("managerList");
        boolean loginYes=false;
        try {
            Manager manager = managerService.getManagerById(managerId);
            Manager managerToRemove=null;
            if (managerList != null) {
                for (Manager oneManager : managerList) {//在老列表里面比对，得到新的已登录列表
                    if (//id、姓名、部门都相同
                            oneManager.getManagerId().equals(manager.getManagerId()) &&
                                    oneManager.getName().equals(manager.getName()) &&
                                    oneManager.getDepartment().getDepartmentName().equals(manager.getDepartment().getDepartmentName())
                            ) {
                        loginYes=true;//确实已经登录
                        managerToRemove=oneManager;
                    }
                }
                if(loginYes ==false) {//服务器未检测到该用户已登录
                    resultMap.put("success", false);
                    resultMap.put("msg", "服务器未检测到该用户已登录！");
                    return resultMap;
                }
                managerList.remove(managerToRemove);//注销
            }
            session.setAttribute("managerList", managerList);//更新已登录用户列表
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
}
