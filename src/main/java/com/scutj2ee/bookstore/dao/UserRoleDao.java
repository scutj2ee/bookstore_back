package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.UserRole;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRoleDao {
    int insertUserRole(UserRole userRole);

    UserRole findUserRoleById(Integer id);

    List<UserRole> selectAll();

    int updateUserRole(UserRole userRole);

    int deleteUserRole(Integer id);
}