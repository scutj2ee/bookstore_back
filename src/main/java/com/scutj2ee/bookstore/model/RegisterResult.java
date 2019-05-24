package com.scutj2ee.bookstore.model;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 10:13
 * @ Description：注册传输层实体类
 * @ Modified By：
 */
public class RegisterResult {
    private Integer code;
    private String msg;
    private boolean exist;
    private String userName;

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

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
