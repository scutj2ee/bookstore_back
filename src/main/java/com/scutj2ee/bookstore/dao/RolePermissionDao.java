package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.RolePermission;

import java.util.List;

public interface RolePermissionDao {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    RolePermission findByPrimaryKey(Integer id);

    List<RolePermission> selectAll();

    int updateByPrimaryKey(RolePermission record);
}