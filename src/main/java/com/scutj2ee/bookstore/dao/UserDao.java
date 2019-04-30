package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.User;

import java.util.List;

public interface UserDao {
    int deleteByPrimaryKey(Integer id);

    int insertUser(User user);

    User selectByPrimaryKey(Integer id);

    List<User> selectAll();

    int updateByPrimaryKey(User record);

    User findByUsername(String username);
}