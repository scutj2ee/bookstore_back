package com.scutj2ee.bookstore.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scutj2ee.bookstore.entity.AdminUser;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.LoginResultEnum;
import com.scutj2ee.bookstore.enums.RegisterResultEnum;
import com.scutj2ee.bookstore.enums.SystemErrorEnum;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.exception.RegisterException;
import com.scutj2ee.bookstore.model.LoginResult;
import com.scutj2ee.bookstore.model.RegisterResult;
import com.scutj2ee.bookstore.model.common.Constant;
import com.scutj2ee.bookstore.service.AdminUserService;
import com.scutj2ee.bookstore.service.LoginService;
import com.scutj2ee.bookstore.service.RegisterService;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.DateUtil;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/29 22:49
 * @ Description：注册控制器类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private UserService userService;

    @PostMapping("/user/register")
    private HashMap<String, Object> registerByUser(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成User对象
        String userStr = HttpServletRequestUtil.getString(request, "user");
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(userStr, User.class);
            //1.比较验证码是否一致或者超时
            String sessionCode = (String) request.getSession().getAttribute("user_code_" + user.getUsername());
            if (sessionCode == null) {
                resultMap.put("success", false);
                resultMap.put("msg", "请先获取验证码");
                return resultMap;
            }
            //获取前端传递过来的code参数
            String verifyCode = HttpServletRequestUtil.getString(request, "verifyCode");
            if (verifyCode != null && verifyCode.equals(sessionCode)) {
                //判断验证码是否过期
                Date sendTime = (Date) request.getSession().getAttribute("user_codeTime_" + user.getUsername());
                long seconds = DateUtil.getDifferenceSeconds(sendTime, new Date());
                if (seconds > Constant.OVERDUESECONDS) {
                    resultMap.put("success", false);
                    resultMap.put("msg", "验证码已过期");
                    return resultMap;
                }
            } else {
                resultMap.put("success", false);
                resultMap.put("msg", "验证码不正确");
                return resultMap;
            }
        } catch (IOException e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.进行注册,user是由是由前端传递过来的json字符串
        try {
            RegisterResult result = registerService.registerByUser(user);
            if (result.getCode().intValue() == RegisterResultEnum.SUCCESS.getCode().intValue()) {
                resultMap.put("success", true);
                resultMap.put("userName", result.getUserName());
            } else {
                resultMap.put("success", false);
            }
            resultMap.put("code", result.getCode());
            resultMap.put("msg", result.getMsg());
            return resultMap;
        } catch (RegisterException e) {
            resultMap.put("success", false);
            resultMap.put("code", e.getCode());
            resultMap.put("msg", e.getMessage());
            return resultMap;
        }
    }

    /**
     * create by: Bin Liu
     * description: 发送邮件验证码
     * create time: 2019/5/24 14:44
     * @Param: null
     * @return
     */
    @PostMapping("/user/code")
    public HashMap<String,Object> sendVerifyCode(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成User对象
        String userStr = HttpServletRequestUtil.getString(request, "user");
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(userStr, User.class);
        } catch (IOException e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        String email = HttpServletRequestUtil.getString(request, "email");
        //2.发送验证码
        try {
            String verifyCode = userService.sendVerifyCode(email);
            if (verifyCode!=null||!verifyCode.equals("")) {
                resultMap.put("success", true);
                //将user返回给前端之后需要使用
                resultMap.put("verifyCode", verifyCode);
                resultMap.put("msg", "发送验证码成功");
            } else {
                resultMap.put("success", false);
                resultMap.put("msg", "发送验证码失败");
            }
            //将验证码信息存入session中
            request.getSession().setAttribute("user_code_" + user.getUsername(),verifyCode);
            request.getSession().setAttribute("user_codeTime_" + user.getUsername(),new Date());
        } catch (LoginException ex) {
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
        }
        return resultMap;
    }

    @PostMapping("/adminUser/apply")
    private HashMap<String, Object> applyByManager(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成Manager对象
        String adminUserStr = HttpServletRequestUtil.getString(request, "adminUser");
        ObjectMapper mapper = new ObjectMapper();
        AdminUser adminUser = null;
        try {
            adminUser = mapper.readValue(adminUserStr, AdminUser.class);
        } catch (IOException e) {
            resultMap.put("success", false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //3.进行注册,manager为前端传递过来的json字符串
        try {
            RegisterResult result = registerService.applyByAdminUser(adminUser);
            if (result.getCode().intValue() == RegisterResultEnum.APPLY_SUCCESS.getCode().intValue()) {
                resultMap.put("success", true);
            } else {
                resultMap.put("success", false);
            }
            resultMap.put("code", result.getCode());
            resultMap.put("msg", result.getMsg());
            return resultMap;
        } catch (RegisterException e) {
            resultMap.put("success", false);
            resultMap.put("code", e.getCode());
            resultMap.put("msg", e.getMessage());
            return resultMap;
        }
    }
}
