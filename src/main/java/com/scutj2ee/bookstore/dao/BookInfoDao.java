package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.BookInfo;

import java.util.List;

public interface BookInfoDao {
    int deleteByPrimaryKey(Integer bookId);

    int insert(BookInfo record);

    BookInfo selectByPrimaryKey(Integer bookId);

    List<BookInfo> selectAll();

    int updateByPrimaryKey(BookInfo record);
}