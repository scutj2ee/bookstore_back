package com.scutj2ee.bookstore.model.dto;

import com.scutj2ee.bookstore.entity.BookCategory;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/7 16:54
 * @ Description：书本类目嵌套类
 * @ Modified By：
 */
public class BookCategoryDto {
    /**
     * 1级类目
     */
    private BookCategory first;
    /**
     * 1级类目对应的2级类目
     */
    private List<BookCategory> secondList;

    public BookCategory getFirst() {
        return first;
    }

    public void setFirst(BookCategory first) {
        this.first = first;
    }

    public List<BookCategory> getSecondList() {
        return secondList;
    }

    public void setSecondList(List<BookCategory> secondList) {
        this.secondList = secondList;
    }
}
