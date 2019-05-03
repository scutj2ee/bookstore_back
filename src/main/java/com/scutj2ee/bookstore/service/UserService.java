package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.User;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/27 23:03
 * @ Description：${description}
 * @ Modified By：
 */
public interface UserService {
    /**通过username查找用户信息;*/
    public User findByUsername(String username);

    User getUserById(int userId);
}
