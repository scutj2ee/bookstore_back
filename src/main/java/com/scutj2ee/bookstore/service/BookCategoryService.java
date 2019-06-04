package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookCategory;
import org.springframework.data.domain.Example;

import java.awt.print.Book;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/12 17:40
 * @description:
 */
public interface BookCategoryService {
    /**
     * 根据id查询
     * @param id
     * @return
     */
    BookCategory findById(Integer id);

    /**
     * 按分类查询所有分类
     * @param type
     * @param pageNo
     * @param pageSize
     * @return
     */
    PageInfo<BookCategory> findByType(Integer type, Integer pageNo, Integer pageSize);

    /**
     * 查找所有分类
     * @return
     */
    List<BookCategory> findAll();

    /**
     *  按条件查询
     *  dao还没写
     */
    List<BookCategory> findAllExample(Example<BookCategory> example);

    /**
     * 更新
     */
    int update(BookCategory bookCategory);

    /**
     * 创建
     */
    int create(BookCategory bookCategory);

    /**
     * 删除
     */
    int deleteById(Integer id);

    PageInfo<BookCategory> getBookCategoryList(Integer pageNo, Integer pageSize);
}
