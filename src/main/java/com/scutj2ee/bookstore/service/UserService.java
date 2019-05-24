package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.User;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/27 23:03
 * @ Description：${description}
 * @ Modified By：
 */
public interface UserService {
    /**
     * create by: Bin Liu
     * description: 通过username查找用户信息
     * create time: 2019/5/24 14:53
     * @Param: null
     * @return
     */
    public User findByUsername(String username);

    User getUserById(int userId);

    List<User> selectAll();

    int insert(User user);

    int update(User user);

    User queryUser(String username, String password);

    /**
     * create by: Bin Liu
     * description: 发送邮件验证码
     * create time: 2019/5/24 14:51
     * @Param: null
     * @return
     */
    String sendVerifyCode(String email);

    /**
     * create by: Bin Liu
     * description: 注册
     * create time: 2019/5/24 14:51
     * @Param: null
     * @return
     */
    Boolean register(User user, String code);
}
