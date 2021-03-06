package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Permission;
import com.scutj2ee.bookstore.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PermissionDao {
    int insertPermisssion(Permission permission);

    Permission findPermisssionById(Integer permissionId);

    List<Permission> selectAll();

    int updatePermission(Permission permission);

    int deletePermission(Integer permissionId);

    List<Permission> findByRoleId(int roleId);

    List<Permission> findPermissionByRole(Role role);
}