package com.scutj2ee.bookstore.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.SystemErrorEnum;
import com.scutj2ee.bookstore.enums.UserResultEnum;
import com.scutj2ee.bookstore.exception.UserException;
import com.scutj2ee.bookstore.model.UserResult;
import com.scutj2ee.bookstore.model.common.Constant;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.DateUtil;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/28 10:39
 * @ Description：用户控制器类
 * @ Modified By：
 */
@Controller
@RequestMapping("")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/usersexit")
    private HashMap<String, Object> userExitOrNot(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            String username = HttpServletRequestUtil.getString(request, "username");
            UserResult userResult = userService.userExitOrNot(username);
            if (userResult.getCode().intValue() == UserResultEnum.SUCCESS.getCode().intValue()) {
                resultMap.put("success", true);
                resultMap.put("user", userResult.getUser());
            } else {
                resultMap.put("success", false);
            }
            resultMap.put("code", userResult.getCode());
            resultMap.put("msg", userResult.getMsg());
        } catch (UserException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
            resultMap.put("code", e.getCode());
        }
        return resultMap;
    }

    @PostMapping("/user/changepassword")
    private HashMap<String, Object> changePassword(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //获取user对应的json字符串
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
        //2.调用userService更新用户密码信息
        try {
            UserResult result = userService.updateUser(user);
            if (result.getCode() == UserResultEnum.SUCCESS.getCode()) {
                resultMap.put("success", true);
            } else {
                resultMap.put("success", false);
            }
            resultMap.put("code", result.getCode());
            resultMap.put("msg", result.getMsg());
            return resultMap;
        } catch (UserException e) {
            resultMap.put("success", false);
            resultMap.put("code", e.getCode());
            resultMap.put("msg", e.getMessage());
            return resultMap;
        }
    }

    @PostMapping("/users/update")
    private HashMap<String, Object> update(HttpServletRequest request, @RequestBody User user) {
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            UserResult userResult = userService.updateUser(user);
            if (userResult.getCode() == UserResultEnum.SUCCESS.getCode()) {
                resultMap.put("success", true);
            } else {
                resultMap.put("success", false);
            }
            resultMap.put("code", userResult.getCode());
            resultMap.put("msg", userResult.getMsg());
            return resultMap;
        } catch (UserException ex) {
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
            return resultMap;
        }
    }

    @PostMapping("/users/delete")
    private HashMap<String, Object> delete(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer id = HttpServletRequestUtil.getInt(request, "id");
        try {
            int result = userService.deleteById(id);
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
}
