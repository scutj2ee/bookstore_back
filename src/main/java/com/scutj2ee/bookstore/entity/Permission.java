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

    private Integer id;
    /**
     * 权限名称
     */
    private String name;
    /**
     * 权限代码字符串
     */
    private String perCode;

    public Permission(){

    }

    public Permission(Integer id, String name, String perCode) {
        this.id = id;
        this.name = name;
        this.perCode = perCode;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", perCode='" + perCode + '\'' +
                '}';
    }
}