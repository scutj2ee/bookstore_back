package com.scutj2ee.bookstore.model;

import com.scutj2ee.bookstore.entity.AdminUser;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 20:56
 * @ Description：管理员操作传输层类
 * @ Modified By：
 */
public class AdminUserResult {
    private Integer code;
    private String msg;
    private AdminUser adminUser;
    private List<AdminUser> adminUserList;

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

    public AdminUser getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(AdminUser adminUser) {
        this.adminUser = adminUser;
    }

    public List<AdminUser> getAdminUserList() {
        return adminUserList;
    }

    public void setAdminUserList(List<AdminUser> adminUserList) {
        this.adminUserList = adminUserList;
    }
}
