package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/27 23:03
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public int insert(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int update(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User queryUser(String username, String password) {
        return null;
    }

    @Override
    public String sendVerifyCode(String email) {
        return null;
    }

    @Override
    public Boolean register(User user, String code) {
        return null;
    }
}
