package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.AdminUserDao;
import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.AdminUser;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.LoginResultEnum;
import com.scutj2ee.bookstore.enums.SystemErrorEnum;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.model.LoginResult;
import com.scutj2ee.bookstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 21:00
 * @ Description：登录业务逻辑实现类
 * @ Modified By：
 */
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private AdminUserDao adminUserDao;

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
            } else if (null != u.getPassword() && !u.getPassword().equals(password)){
                //用户名密码是否一致
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
    public LoginResult loginByAdminUser(String username, String password) {
        LoginResult loginResult = new LoginResult();
        if (password == null){
            loginResult.setCode(LoginResultEnum.INPUT_NULL.getCode());
            loginResult.setMsg(LoginResultEnum.INPUT_NULL.getMsg());
            return loginResult;
        }
        try{
            AdminUser adminUser = adminUserDao.findAdminUserByUserNameAndPassord(username,password);
            if (adminUser == null) {
                loginResult.setCode(LoginResultEnum.NOT_MATCH.getCode());
                loginResult.setMsg(LoginResultEnum.NOT_MATCH.getMsg());
            } else {
                loginResult.setCode(LoginResultEnum.SUCCESS.getCode());
                loginResult.setMsg(LoginResultEnum.SUCCESS.getMsg());
                loginResult.setAdminUser(adminUser);
            }
            return loginResult;
        }catch (Exception e){
            throw new LoginException(SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg(),SystemErrorEnum.SYSTEM_INNER_ERROR.getCode());
        }
    }
}
