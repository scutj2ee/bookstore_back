package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.UserRole;

import java.util.List;

public interface UserRoleDao {
    int insertUserRole(UserRole userRole);

    UserRole findUserRoleById(Integer id);

    List<UserRole> selectAll();

    int updateUserRole(UserRole userRole);

    int deleteUserRole(Integer id);
}