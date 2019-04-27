package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.pojo.ResultBean;
import com.scutj2ee.bookstore.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/27 19:07
 * @ Description：邮件控制器类
 * @ Modified By：
 */
@RestController
@RequestMapping("/mail")
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/getCheckCode", method = RequestMethod.POST)
    public ResultBean<String> getCheckCode(@RequestBody User user){
        logger.info("进入方法getCheckCode:"+user.toString());
        ResultBean  resultBean= new ResultBean();
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            mailService.sendSimpleMail(user.getEmail(), "注册验证码", message);
        }catch (Exception e){
            resultBean.setData(e);
            return resultBean;
        }
        resultBean.setData(checkCode);
        return resultBean;
    }
}
