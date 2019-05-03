package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.Permission;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/28 10:28
 * @ Description：权限逻辑接口
 * @ Modified By：
 */
public interface PermissionService {
    List<Permission> findByRoleId(int roleId);

    Permission findByPermissionId(int permissionId);

    int updatePermission(Permission permission);

    int insertPrivilege(Permission permission);

    int deleteByPermissionId(int permissionId);
}
