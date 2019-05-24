package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.model.UserResult;

import java.util.List;
import java.util.Map;

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

    User getUserById(Integer userId);

    List<User> selectAll();

    int insert(User user);

    UserResult updateUser(User user);

    int deleteById(Integer id);

    /**
     * create by: Bin Liu
     * description:
     * create time: 2019/5/24 23:02
     * @Param: null
     * @return 
     */
    UserResult userExitOrNot(String username);

    /**
     * create by: Bin Liu
     * description: 获取用户列表
     * create time: 2019/5/24 23:09
     * @Param: null
     * @return
     */
    PageInfo<User> getUserList(Map map, Integer pageNo, Integer pageSize);
}
