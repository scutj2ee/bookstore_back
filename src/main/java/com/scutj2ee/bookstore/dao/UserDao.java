package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserDao {
    int deleteUser(Integer id);

    int insertUser(User user);

    User findUserById(Integer id);

    List<User> selectAll();

    int updateUser(User user);

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    List<User> getUserListByParams(Map map);
}