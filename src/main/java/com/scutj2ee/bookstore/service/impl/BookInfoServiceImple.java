package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.BookInfoDao;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/16 22:41
 * @description:
 */
public class BookInfoServiceImple implements BookInfoService {
    @Autowired
    private BookInfoDao bookInfoDao;
    @Override
    public BookInfo findById(Integer id) {
        return bookInfoDao.findBookInfoById(id);
    }

    @Override
    public List<BookInfo> findAll() {
        return bookInfoDao.selectAll();
    }

    @Override
    public List<BookInfo> findByBookCategoryId(Integer bookCategoryId) {
        return bookInfoDao.findByBookCategoryId(bookCategoryId);
    }

    @Override
    public List<BookInfo> findNewBook() {
        return bookInfoDao.findNew();
    }

    @Override
    public void update(BookInfo bookInfo) {
        bookInfoDao.updateBookInfo(bookInfo);
    }

    @Override
    public void create(BookInfo bookInfo) {
        bookInfoDao.insertBookInfo(bookInfo);
    }

    @Override
    public void deleteById(Integer id) {
        bookInfoDao.deleteBookInfo(id);
    }

    @Override
    public List<BookInfo> findByTitleIsLike(String keyword) {
        return null;
    }
}
