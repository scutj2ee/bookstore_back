package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.Permission;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/28 10:28
 * @ Description：${description}
 * @ Modified By：
 */
public interface ResourceService {
    List<Permission> findByRoleId(int roleId);
}
