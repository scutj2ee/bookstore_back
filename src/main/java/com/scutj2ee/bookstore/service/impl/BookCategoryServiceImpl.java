package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.BookCategoryDao;
import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/16 20:14
 * @description:
 */
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Override
    public BookCategory findById(Integer id) {
        return bookCategoryDao.findBookCategoryById(id);
    }

    @Override
    public List<BookCategory> findByType(Integer type) {
        return bookCategoryDao.findByType(type);
    }

    @Override
    public List<BookCategory> findAll() {
        return bookCategoryDao.selectAll();
    }

    @Override
    public List<BookCategory> findAllExample(Example<BookCategory> example) {
        return null;
    }

    @Override
    public void update(BookCategory bookCategory) {
        bookCategoryDao.updateBookCategory(bookCategory);
    }

    @Override
    public int create(BookCategory bookCategory) {
        return bookCategoryDao.insertBookCategory(bookCategory);
    }

    @Override
    public void deleteById(Integer id) {
        bookCategoryDao.deleteBookCategory(id);
    }

    @Override
    public List<BookCategory> findByParentId(int pid) {
        return bookCategoryDao.findByParentId(pid);
    }
}
