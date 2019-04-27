package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.RoleResource;

import java.util.List;

public interface RoleResourceDao {
    int deleteByPrimaryKey(Integer id);

    int insert(RoleResource record);

    RoleResource selectByPrimaryKey(Integer id);

    List<RoleResource> selectAll();

    int updateByPrimaryKey(RoleResource record);
}