package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.Role;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/28 10:20
 * @ Description：${description}
 * @ Modified By：
 */
public interface RoleService {
    List<Role> findRolebyUserId(int userId);

    Role findByRoleId(int roleId);

    int deleteByRoleId(int roleId);

    int insertRole(Role role);

    int updateRole(Role role);
}
