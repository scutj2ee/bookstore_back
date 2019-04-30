package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Permission;

import java.util.List;

public interface PermissionDao {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(Permission record);

    Permission findPermisssionById(Integer resourceId);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<Permission> findByRoleId(int roleId);
}