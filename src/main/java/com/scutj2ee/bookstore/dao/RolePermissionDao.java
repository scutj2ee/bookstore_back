package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.RolePermission;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface RolePermissionDao {
    int insertRolePermission(RolePermission record);

    RolePermission findRolePermissionById(Integer id);

    List<RolePermission> selectAll();

    int deleteRolePermission(Integer id);

    int updateRolePermission(RolePermission rolePermission);
}