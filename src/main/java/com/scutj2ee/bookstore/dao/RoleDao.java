package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Role;

import java.util.List;

public interface RoleDao {
    int deleteByPrimaryKey(Integer roleId);

    int insert(Role record);

    Role findByPrimaryKey(Integer roleId);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Role> findbyUserId(int userId);
}