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
import com.scutj2ee.bookstore.service.AdminUserService;
import com.scutj2ee.bookstore.service.LoginService;
import com.scutj2ee.bookstore.service.RegisterService;
import com.scutj2ee.bookstore.service.UserService;
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

    @PostMapping("/users/register")
    private HashMap<String, Object> registerByUser(HttpServletRequest request) {
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
        //3.进行注册,user是由是由前端传递过来的json字符串
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
    @PostMapping("code")
    public ResponseEntity<String> senVerifyCode(@RequestParam("eamil") String email){
        String code = this.registerService.sendVerifyCode(email);
        if (code == null || code.equals("")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(code);
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
