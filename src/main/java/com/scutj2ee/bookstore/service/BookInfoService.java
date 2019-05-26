package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookInfo;

import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/15 12:38
 * @description:
 */
public interface BookInfoService {
    /**
     * 根据id查询
     */
    BookInfo findById(Integer id);

    /**
     * 查询所有书
     */
    List<BookInfo> findAll();

    /**
     * 根据书的类别查找商品
     */
    List<BookInfo> findByBookCategoryId(Integer bookCategoryId);

    /**
     * 查找最新产品
     *
     */
    List<BookInfo> findNewBook();

    /**
     * 更新
     */
    int update(BookInfo bookInfo);

    /**
     * 创建
     */
    int create(BookInfo bookInfo);

    /**
     * 删除
     */
    int deleteById(Integer id);

    /**
     * 根据关键字搜索书
     */
    List<BookInfo> findByTitleIsLike(String keyword);

    PageInfo<BookInfo> getUserList(Integer pageNo, Integer pageSize);
}
