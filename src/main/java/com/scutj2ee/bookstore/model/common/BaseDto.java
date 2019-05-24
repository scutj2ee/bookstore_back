package com.scutj2ee.bookstore.model.common;

import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 12:44
 * @ Description：${description}
 * @ Modified By：
 */
public class BaseDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 当前页数 */
    @Transient
    @Min(value = 1, message = "当前页数不能小于1")
    private Integer page;

    /** 每页条数 */
    @Transient
    @Min(value = 1, message = "每页条数不能小于1")
    @Max(value = 50, message = "每页条数不能大于50")
    private Integer rows;

    /** 排序的列名 */
    @Transient
    private String sidx;

    /** 排序规则(DESC或者ESC) */
    @Transient
    private String sort;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
