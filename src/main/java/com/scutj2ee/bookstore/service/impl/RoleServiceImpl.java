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
    public List<Role> findbyUserId(int userId) {
        return roleDao.findbyUserId(userId);
    }
}
