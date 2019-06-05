package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.AdminUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 20:35
 * @ Description：管理员Dao
 * @ Modified By：
 */
@Component
public interface AdminUserDao {
    int deleteUser(Integer id);

    int insertAdminUser(AdminUser adminUser);

    AdminUser findAdminUserById(Integer id);

    List<AdminUser> selectAll();

    int updateAdminUser(AdminUser adminUser);

    AdminUser findAdminUserByUserNameAndPassord(@Param("username")String username, @Param("password")String password);
}
