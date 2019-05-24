package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.model.LoginResult;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/3 9:29
 * @ Description：登录业务逻辑接口
 * @ Modified By：
 */
public interface LoginService {
    /**
     * create by: Bin Liu
     * description: 用户登录
     * create time: 2019/5/3 9:30
     * @Param: null
     * @return
     */
    LoginResult loginByUser(String username, String password);

    LoginResult loginByAdmin(String username, String password);
}
