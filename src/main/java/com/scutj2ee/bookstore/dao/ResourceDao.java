package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Resource;

import java.util.List;

public interface ResourceDao {
    int deleteByPrimaryKey(Integer resourceId);

    int insert(Resource record);

    Resource selectByPrimaryKey(Integer resourceId);

    List<Resource> selectAll();

    int updateByPrimaryKey(Resource record);

    List<Resource> findByRoleId(int roleId);
}