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
     * 根据书的类别查找商品
     * @param bookCategoryId
     * @return
     */
    PageInfo<BookInfo> findByBookCategoryId(Integer bookCategoryId, Integer pageNo, Integer pageSize);

    /**
     * 查找最新产品
     * @return
     */
    PageInfo<BookInfo> findNewBook(Integer pageNo, Integer pageSize);

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
     * 查找所有书
     */
    PageInfo<BookInfo> getBookInfoList(Integer pageNo, Integer pageSize);
}
