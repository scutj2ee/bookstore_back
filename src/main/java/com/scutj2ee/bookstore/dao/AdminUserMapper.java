package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.AdminUser;

import java.util.List;

public interface AdminUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AdminUser record);

    AdminUser selectByPrimaryKey(Integer id);

    List<AdminUser> selectAll();

    int updateByPrimaryKey(AdminUser record);
}