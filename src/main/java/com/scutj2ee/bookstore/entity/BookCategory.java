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

    private Integer id;
    /**
     * 类别名称
     */
    private String name;
    /**
     * 状态 1上架 0下架
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 修改时间
     */
    private Date updated;
    /**
     * 上级分类Id
     */
    private Integer parentId;
    /**
     * 类型 1一级分类 2二级分类
     */
    private Integer type;

    public BookCategory(){

    }

    public BookCategory(Integer id, String name, Integer status, Date created, Date updated, Integer parentId, Integer type) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.created = created;
        this.updated = updated;
        this.parentId = parentId;
        this.type = type;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", created=" + created +
                ", updated=" + updated +
                ", parentId=" + parentId +
                ", type=" + type +
                '}';
    }
}