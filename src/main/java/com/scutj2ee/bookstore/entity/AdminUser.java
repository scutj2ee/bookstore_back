package com.scutj2ee.bookstore.entity;

import java.io.Serializable;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 20:29
 * @ Description：管理员
 * @ Modified By：
 */
public class AdminUser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    public AdminUser(){

    }

    public AdminUser(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
