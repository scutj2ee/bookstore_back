package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.BookInfo;

import java.util.List;

public interface BookInfoDao {
    int deleteBookInfo(Integer bookId);

    int insertBookInfo(BookInfo bookInfo);

    BookInfo findBookInfoById(Integer bookId);

    List<BookInfo> selectAll();

    int updateBookInfo(BookInfo bookInfo);

    List<BookInfo> findByBookCategoryId(Integer bookCategoryId);

    /**
     * create by: Bin Liu
     * description: 查找上架一个月的书本
     * create time: 2019/5/19 9:48
     * @Param: null
     * @return
     */
    List<BookInfo> findNew();

    List<BookInfo> getBookInfoListByParams();
}