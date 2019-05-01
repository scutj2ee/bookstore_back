package com.scutj2ee.bookstore.entity;

import java.io.Serializable;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/1 15:36
 * @ Description：权限实体类
 * @ Modified By：
 */


public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer permissionId;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限url
     */
    private String url;
    /**
     * 权限上级id
     */
    private Integer fatherId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getFatherId() {
        return fatherId;
    }

    public void setFatherId(Integer fatherId) {
        this.fatherId = fatherId;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", fatherId='" + fatherId + '\'' +
                '}';
    }
}