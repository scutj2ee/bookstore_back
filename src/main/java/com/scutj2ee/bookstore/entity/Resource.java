package com.scutj2ee.bookstore.entity;

import java.io.Serializable;

public class Resource implements Serializable {
    private Integer resourceId;
    private String resname;
    private static final long serialVersionUID = 1L;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResname() {
        return resname;
    }

    public void setResname(String resname) {
        this.resname = resname == null ? null : resname.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resourceId=").append(resourceId);
        sb.append(", resname=").append(resname);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}