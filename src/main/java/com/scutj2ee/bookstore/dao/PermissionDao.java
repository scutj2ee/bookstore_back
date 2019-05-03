package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Permission;

import java.util.List;

public interface PermissionDao {
    int insertPermisssion(Permission permission);

    Permission findPermisssionById(Integer permissionId);

    List<Permission> selectAll();

    int updatePermission(Permission permission);

    int deletePermission(Integer permissionId);

    List<Permission> findByRoleId(int roleId);
}