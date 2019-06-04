package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.BookCategoryDao;
import com.scutj2ee.bookstore.dao.BookInfoDao;
import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.service.BookInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/16 22:41
 * @description:
 */
@Service
public class BookInfoServiceImple implements BookInfoService {
    @Autowired
    private BookInfoDao bookInfoDao;
    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Override
    public BookInfo findById(Integer id) {
        return bookInfoDao.findBookInfoById(id);
    }

    @Override
    public PageInfo<BookInfo> findByBookCategoryId(Integer bookCategoryId, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<BookInfo> bookInfoLists = bookInfoDao.findByBookCategoryId(bookCategoryId);
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(bookInfoLists);
        return pageInfo;
    }

    @Override
    public PageInfo<BookInfo> findNewBook(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<BookInfo> newBooks = bookInfoDao.findNew();
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(newBooks);
        return pageInfo;
    }

    @Override
    public int update(BookInfo bookInfo) {
        return bookInfoDao.updateBookInfo(bookInfo);
    }

    @Override
    public int create(BookInfo bookInfo) {
        return bookInfoDao.insertBookInfo(bookInfo);
    }

    @Override
    public int deleteById(Integer id) {
        return bookInfoDao.deleteBookInfo(id);
    }

    @Override
    public PageInfo<BookInfo> getBookInfoList(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<BookInfo> list = bookInfoDao.selectAll();
        for(BookInfo bookInfo:list){
            BookCategory bookCategory=bookCategoryDao.findBookCategoryById(bookInfo.getBookCategoryId());
            bookInfo.setBookCategory(bookCategory);
        }
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
