package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.model.LoginResult;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 20:44
 * @ Description：登录逻辑接口
 * @ Modified By：
 */
public interface LoginService {
    /**
     * create by: Bin Liu
     * description: 用户登陆
     * create time: 2019/5/24 20:52
     * @Param: null
     * @return 
     */
    LoginResult loginByUser(String userName, String password);

    /**
     * create by: Bin Liu
     * description: 管理员登陆
     * create time: 2019/5/24 20:53
     * @Param: null
     * @return 
     */
    LoginResult loginByAdminUser(String userName, String password);
}
