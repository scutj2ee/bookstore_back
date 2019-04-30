package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.BookInfo;

import java.util.List;

public interface BookInfoDao {
    int deleteBookInfo(Integer bookId);

    int insertBookInfo(BookInfo bookInfo);

    BookInfo findBookInfoById(Integer bookId);

    List<BookInfo> selectAll();

    int updateBookInfo(BookInfo bookInfo);
}