package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.AdminUserDao;
import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.AdminUser;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.RegisterResultEnum;
import com.scutj2ee.bookstore.exception.CustomException;
import com.scutj2ee.bookstore.exception.RegisterException;
import com.scutj2ee.bookstore.model.RegisterResult;
import com.scutj2ee.bookstore.service.RegisterService;
import com.scutj2ee.bookstore.utils.MailUtil;
import com.scutj2ee.bookstore.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.OptionalInt;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 21:20
 * @ Description：注册业务逻辑实现类
 * @ Modified By：
 */
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private AdminUserDao adminUserDao;

    @Transactional
    @Override
    public RegisterResult registerByUser(User user) throws RegisterException {
        RegisterResult result = new RegisterResult();
        //1.判断输入是否为空
        if (user == null ) {
            result.setCode(RegisterResultEnum.INPUT_NULL.getCode());
            result.setMsg(RegisterResultEnum.INPUT_NULL.getMsg());
            return result;
        }
        try {
            //1.判断用户是否存在数据库中，如果不存在
            User oldUser = userDao.findByUsername(user.getUsername());
            if (oldUser != null) {
                // 用户已经存在
                result.setExist(true);
                result.setCode(RegisterResultEnum.USER_FAILD.getCode());
                result.setMsg(RegisterResultEnum.USER_FAILD.getMsg());
            }
            //3.插入用户信息，其实这里就是为了简便，不再捕获系统可能出现的异常，更复杂的逻辑是先判断用户是否存在，再去判断是否出现系统异常
            if (userDao.insertUser(user) == 1) {
                result.setCode(RegisterResultEnum.SUCCESS.getCode());
                result.setMsg(RegisterResultEnum.SUCCESS.getMsg());
            } else {
                result.setCode(RegisterResultEnum.USER_FAILD.getCode());
                result.setMsg(RegisterResultEnum.USER_FAILD.getMsg());
            }
            return result;
        } catch (Exception ex) {
            throw new RegisterException(RegisterResultEnum.USER_EXIST.getCode(), RegisterResultEnum.USER_EXIST.getMsg());
        }
    }

    @Transactional
    @Override
    public RegisterResult applyByAdminUser(AdminUser adminUser) {
        RegisterResult result = new RegisterResult();
        //1.判断输入是否为空
        if (adminUser == null ) {
            result.setCode(RegisterResultEnum.INPUT_NULL.getCode());
            result.setMsg(RegisterResultEnum.INPUT_NULL.getMsg());
            return result;
        }
        try {
            //3.插入管理员信息
            if (adminUserDao.insertAdminUser(adminUser) == 1) {
                result.setCode(RegisterResultEnum.APPLY_SUCCESS.getCode());
                result.setMsg(RegisterResultEnum.APPLY_SUCCESS.getMsg());
            } else {
                result.setCode(RegisterResultEnum.ADMINUSER_FAILD.getCode());
                result.setMsg(RegisterResultEnum.ADMINUSER_FAILD.getMsg());
            }
            return result;
        } catch (Exception ex) {
            throw new RegisterException(RegisterResultEnum.APPLY_REPEAT.getCode(), RegisterResultEnum.APPLY_REPEAT.getMsg());
        }
    }

    @Override
    public String sendVerifyCode(String email) {
        //1.生成验证码
        String checkCode = RandomUtil.getRandomVerCode();
        String message = "您的注册验证码为：" + checkCode;
        //3.发送邮件
        try {
            mailUtil.sendSimpleMail(email, "注册验证码", message);
        } catch (Exception e) {
            throw new CustomException("发送邮箱验证码失败");
        }
        return checkCode;
    }
}
