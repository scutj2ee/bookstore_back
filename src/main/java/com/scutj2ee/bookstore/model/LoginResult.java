package com.scutj2ee.bookstore.model;

import com.scutj2ee.bookstore.entity.User;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 10:09
 * @ Description：登录传输层实体类
 * @ Modified By：
 */
public class LoginResult {
    private Integer code;
    private String msg;
    private User user;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
