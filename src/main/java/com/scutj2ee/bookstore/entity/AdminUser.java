package com.scutj2ee.bookstore.entity;

import java.io.Serializable;

public class AdminUser implements Serializable {
    private Integer id;
    private Integer isSaleMan;
    private String password;
    private String userName;
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIsSaleMan() {
        return isSaleMan;
    }

    public void setIsSaleMan(Integer isSaleMan) {
        this.isSaleMan = isSaleMan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", isSaleMan=").append(isSaleMan);
        sb.append(", password=").append(password);
        sb.append(", userName=").append(userName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}