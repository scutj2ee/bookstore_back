package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.UserRole;

import java.util.List;

public interface UserRoleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    UserRole findByPrimaryKey(Integer id);

    List<UserRole> selectAll();

    int updateByPrimaryKey(UserRole record);
}