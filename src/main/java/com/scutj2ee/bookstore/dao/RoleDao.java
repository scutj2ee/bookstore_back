package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Role;
import com.scutj2ee.bookstore.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RoleDao {
    int insertRole(Role role);

    Role findRoleById(Integer roleId);

    List<Role> selectAll();

    int updateRole(Role role);

    int deleteRole(Integer roleId);

    List<Role> findRolebyUserId(int userId);

    List<Role> findRoleByUser(User user);
}