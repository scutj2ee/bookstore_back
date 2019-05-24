package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.RegisterResultEnum;
import com.scutj2ee.bookstore.exception.RegisterException;
import com.scutj2ee.bookstore.model.RegisterResult;
import com.scutj2ee.bookstore.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 11:03
 * @ Description：注册逻辑实现类
 * @ Modified By：
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public RegisterResult registerByUser(User user) throws RegisterException {
        RegisterResult result = new RegisterResult();
        //1.判断输入是否为空
        if (user == null) {
            result.setCode(RegisterResultEnum.INPUT_NULL.getCode());
            result.setMsg(RegisterResultEnum.INPUT_NULL.getMsg());
            return result;
        }
        try {
            //2.设置user的初始值
            user.setIntegration(0);
            //3.插入用户信息，其实这里就是为了简便，不再捕获系统可能出现的异常，更复杂的逻辑是先判断用户是否存在，再去判断是否出现系统异常
            if (userDao.insertUser(user) == 1){
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

    @Override
    public RegisterResult applyByAdmin(User user) {
        RegisterResult result = new RegisterResult();
        //1.判断输入是否为空
        if (user == null) {
            result.setCode(RegisterResultEnum.INPUT_NULL.getCode());
            result.setMsg(RegisterResultEnum.INPUT_NULL.getMsg());
            return result;
        }
        try {
            //2.设置user的初始值
            user.setIntegration(0);
            //3.插入用户信息，其实这里就是为了简便，不再捕获系统可能出现的异常，更复杂的逻辑是先判断用户是否存在，再去判断是否出现系统异常
            if (userDao.insertUser(user) == 1){
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
}
