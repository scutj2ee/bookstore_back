package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.LoginResultEnum;
import com.scutj2ee.bookstore.enums.SystemErrorEnum;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.pojo.LoginResult;
import com.scutj2ee.bookstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/3 9:31
 * @ Description：登录业务逻辑实现类
 * @ Modified By：
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Override
    public LoginResult loginByUser(String username, String password) {
        LoginResult loginResult = new LoginResult();
        if (username == null || password == null){
            loginResult.setCode(LoginResultEnum.INPUT_NULL.getCode());
            loginResult.setMsg(LoginResultEnum.INPUT_NULL.getMsg());
            return loginResult;
        }
        try{
            User u = userDao.findByUsername(username);
            //用户是否存在
            if (u == null){
                loginResult.setCode(LoginResultEnum.USER_NOT_EXIT.getCode());
                loginResult.setMsg(LoginResultEnum.USER_NOT_EXIT.getMsg());
            //用户名密码是否一致
            } else if (null != u.getPassword() && !u.getPassword().equals(password)){
                loginResult.setCode(LoginResultEnum.NOT_MATCH.getCode());
                loginResult.setMsg(LoginResultEnum.NOT_MATCH.getMsg());
            } else{
                loginResult.setCode(LoginResultEnum.SUCCESS.getCode());
                loginResult.setMsg(LoginResultEnum.SUCCESS.getMsg());
                loginResult.setUser(u);
            }
            return loginResult;
        }catch (Exception e){
            throw new LoginException(SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg(),SystemErrorEnum.SYSTEM_INNER_ERROR.getCode());
        }
    }

    @Override
    public LoginResult loginByAdmin(String username, String password) {
        return null;
    }
}
