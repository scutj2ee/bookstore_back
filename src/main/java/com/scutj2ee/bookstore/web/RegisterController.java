package com.scutj2ee.bookstore.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.RegisterResultEnum;
import com.scutj2ee.bookstore.enums.SystemErrorEnum;
import com.scutj2ee.bookstore.exception.RegisterException;
import com.scutj2ee.bookstore.model.RegisterResult;
import com.scutj2ee.bookstore.service.MailService;
import com.scutj2ee.bookstore.service.RegisterService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import com.scutj2ee.bookstore.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

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
    private MailService mailService;

    @Autowired
    private RegisterService registerService;

    /**
     * create by: Bin Liu
     * description: 获取前台的输入的邮箱参数，发送验证码
     * create time: 2019/4/30 10:19
     * @Param: request
     * @return
     */
    @RequestMapping(value = "/getCheckCode", method = RequestMethod.POST)
    public HashMap<String, Object> getCheckCode(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取前台的邮件地址参数
        String email = HttpServletRequestUtil.getString(request, "email");
        ObjectMapper mapper = new ObjectMapper();
        //2.生成验证码
        String checkCode = RandomUtil.getRandomVerCode();
        String message = "您的注册验证码为：" + checkCode;
        //3.发送邮件
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
            resultMap.put("success",true);
            resultMap.put("checkCode",checkCode);
        } catch (Exception e) {
            resultMap.put("success",false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        return resultMap;
    }

    /**
     * create by: Bin Liu
     * description: 用户注册
     * create time: 2019/4/30 10:46
     * @Param: request
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public HashMap<String,Object> register(HttpServletRequest request) {
        HashMap<String,Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成User对象
        String userStr = HttpServletRequestUtil.getString(request,"user");
        ObjectMapper mapper = new ObjectMapper();
        User user = null;
        try {
            user = mapper.readValue(userStr,User.class);
        } catch (IOException e) {
            resultMap.put("success",false);
            resultMap.put("msg", SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg());
            return resultMap;
        }
        //2.进行注册,user是由是由前端传递过来的json字符串
        try{
            RegisterResult result = registerService.registerByUser(user);
            if (result.getCode().equals(RegisterResultEnum.SUCCESS.getCode())){
                resultMap.put("success",true);
            }else{
                resultMap.put("success",false);
            }
            resultMap.put("code",result.getCode());
            resultMap.put("msg",result.getMsg());
            return resultMap;
        }catch (RegisterException e){
            resultMap.put("success",false);
            resultMap.put("code",e.getCode());
            resultMap.put("msg",e.getMessage());
            return resultMap;
        }
    }
}
