package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.entity.AdminUser;
import com.scutj2ee.bookstore.model.AdminUserResult;
import com.scutj2ee.bookstore.service.AdminUserService;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 20:58
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Override
    public AdminUser getAdminUserById(int id) {
        return null;
    }

    @Override
    public AdminUser getManager(String userName, String password) {
        return null;
    }

    @Override
    public AdminUserResult adminUserExitOrNot(String userName) {
        return null;
    }

    @Override
    public AdminUserResult updateAdminUser(AdminUser adminUser) {
        return null;
    }

    @Override
    public int deleteAdminUser(Integer id) {
        return 0;
    }
}
