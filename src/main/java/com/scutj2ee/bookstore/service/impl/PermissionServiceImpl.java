package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.PermissionDao;
import com.scutj2ee.bookstore.entity.Permission;
import com.scutj2ee.bookstore.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/28 10:29
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findByRoleId(int roleId) {
        return permissionDao.findByRoleId(roleId);
    }

    @Override
    public Permission findByPermissionId(int permissionId) {
        return permissionDao.findPermisssionById(permissionId);
    }

    @Override
    public int updatePermission(Permission permission) {
        return permissionDao.updatePermission(permission);
    }

    @Override
    public int insertPrivilege(Permission permission) {
        return permissionDao.insertPermisssion(permission);
    }

    @Override
    public int deleteByPermissionId(int permissionId) {
        return permissionDao.deletePermission(permissionId);
    }
}
