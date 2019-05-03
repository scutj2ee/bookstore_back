package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.RolePermission;

import java.util.List;

public interface RolePermissionDao {
    int insertRolePermission(RolePermission record);

    RolePermission findRolePermissionById(Integer id);

    List<RolePermission> selectAll();

    int deleteRolePermission(Integer id);

    int updateRolePermission(RolePermission rolePermission);
}