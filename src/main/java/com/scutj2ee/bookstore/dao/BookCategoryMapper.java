package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.BookCategory;

import java.util.List;

public interface BookCategoryMapper {
    int deleteByPrimaryKey(Integer cateId);

    int insert(BookCategory record);

    BookCategory selectByPrimaryKey(Integer cateId);

    List<BookCategory> selectAll();

    int updateByPrimaryKey(BookCategory record);
}