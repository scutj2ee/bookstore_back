package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.BookInfoDao;
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
    public List<BookInfo> findByTitleIsLike(String keyword) {
        return null;
    }

    @Override
    public PageInfo<BookInfo> getUserList(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<BookInfo> list = bookInfoDao.getUserListByParams();
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<BookInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
