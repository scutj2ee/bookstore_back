package com.scutj2ee.bookstore.entity;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    /**用户积分*/
    private Integer integration;
    private String email;
    private String password;
    private String phone;
    private String username;

    public User(Integer id,String email,String phone,String password,String username){
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIntegration() {
        return integration;
    }

    public void setIntegration(Integer integration) {
        this.integration = integration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", username=").append(username);
        sb.append(", integration=").append(integration);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}