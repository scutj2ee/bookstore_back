package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.pojo.RegisterResult;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 11:02
 * @ Description：注册逻辑接口
 * @ Modified By：
 */
public interface RegisterService {
    /**
     * create by: Bin Liu
     * description: 用户注册
     * create time: 2019/4/30 11:03
     * @Param: null
     * @return 
     */
    RegisterResult registerByUser(User user);
    
}
