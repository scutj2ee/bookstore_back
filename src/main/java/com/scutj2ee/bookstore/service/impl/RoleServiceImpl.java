package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.RoleDao;
import com.scutj2ee.bookstore.entity.Role;
import com.scutj2ee.bookstore.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/28 10:20
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findRolebyUserId(int userId) {
        return roleDao.findRolebyUserId(userId);
    }

    @Override
    public Role findByRoleId(int roleId) {
        return roleDao.findRoleById(roleId);
    }

    @Override
    public int deleteByRoleId(int roleId) {
        return roleDao.deleteRole(roleId);
    }

    @Override
    public int insertRole(Role role) {
        return roleDao.insertRole(role);
    }

    @Override
    public int updateRole(Role role) {
        return roleDao.updateRole(role);
    }
}
