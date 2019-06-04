package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.BookCategoryDao;
import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/16 20:14
 * @description:
 */
@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Override
    public BookCategory findById(Integer id) {
        return bookCategoryDao.findBookCategoryById(id);
    }

    @Override
    public PageInfo<BookCategory> findByType(Integer type, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<BookCategory> list = bookCategoryDao.findByType(type);
        PageHelper.startPage(pageNo, pageSize);
        PageInfo<BookCategory> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<BookCategory> findAll() {
        List<BookCategory> list = bookCategoryDao.selectAll();
        return list;
    }

    @Override
    public List<BookCategory> findAllExample(Example<BookCategory> example) {
        return null;
    }

    @Override
    public int update(BookCategory bookCategory) {
        return bookCategoryDao.updateBookCategory(bookCategory);
    }

    @Override
    public int create(BookCategory bookCategory) {
        return bookCategoryDao.insertBookCategory(bookCategory);
    }

    @Override
    public int deleteById(Integer id) {
        return bookCategoryDao.deleteBookCategory(id);
    }

    @Override
    public PageInfo<BookCategory> getBookCategoryList(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<BookCategory> list = bookCategoryDao.getBookCategoryListByParams();
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<BookCategory> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
