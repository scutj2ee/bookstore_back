package com.scutj2ee.bookstore.entity;

import java.io.Serializable;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/1 15:36
 * @ Description：角色实体类
 * @ Modified By：
 */

public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer roleId;
    /**
     * 角色名称
     */
    private String rolename;
    /**
     * 角色类型 1表示用户 2表示管理员
     */
    private Integer type;

    public Role(){

    }

    public Role(Integer roleId, String rolename, Integer type) {
        this.roleId = roleId;
        this.rolename = rolename;
        this.type = type;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", rolename='" + rolename + '\'' +
                ", type=" + type +
                '}';
    }
}