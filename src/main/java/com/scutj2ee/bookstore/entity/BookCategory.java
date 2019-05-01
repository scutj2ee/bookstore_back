package com.scutj2ee.bookstore.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/1 10:42
 * @ Description：书本分类实体类
 * @ Modified By：
 */

public class BookCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer cateId;
    /**
     * 父级id
     */
    private Integer parentId;
    private String name;
    /**
     * 状态 1上架 0下架
     */
    private Integer status;
    /**
     * 类型 1一级分类 2二级分类
     */
    private Integer type;
    private Date created;
    private Date updated;

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "cateId=" + cateId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}