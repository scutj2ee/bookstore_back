package com.scutj2ee.bookstore.model.dto;

import com.scutj2ee.bookstore.entity.BookCategory;

import java.io.Serializable;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/7 16:54
 * @ Description：书本类目嵌套类
 * @ Modified By：
 */
public class BookCategoryDto implements Serializable {
    /**
     * 类目id
     */
    private Integer id;
    /**
     * 类目名称
     */
    private String name;
    /**
     * 1级类目对应的2级类目
     */
    private List<BookCategoryDto> child;

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

    public List<BookCategoryDto> getChild() {
        return child;
    }

    public void setChild(List<BookCategoryDto> child) {
        this.child = child;
    }
}
