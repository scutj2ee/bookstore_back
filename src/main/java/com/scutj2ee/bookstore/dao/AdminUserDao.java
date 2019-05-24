package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.AdminUser;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 20:35
 * @ Description：管理员Dao
 * @ Modified By：
 */
public interface AdminUserDao {
    int deleteUser(Integer id);

    int insertAdminUser(AdminUser adminUser);

    AdminUser findAdminUserById(Integer id);

    List<AdminUser> selectAll();

    int updateAdminUser(AdminUser adminUser);

    AdminUser findAdminUserByUserNameAndPassord(String username, String password);
}
