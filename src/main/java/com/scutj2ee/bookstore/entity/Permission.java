package com.scutj2ee.bookstore.entity;

import java.io.Serializable;

public class Permission implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer permissionId;
    private String name;
    private String url;
    private String fatherId;

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

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
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