package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.model.dto.BookInfoDto;

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
     * 根据书的一级类别查找商品
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
     * @Author Bin Liu
     * @Description 查找所有书
     * @Date 2019/6/4 16:22
     * @param
     * @return
     */
    PageInfo<BookInfoDto> getBookInfoList(Integer pageNo, Integer pageSize);

    /**
     * @Author Bin Liu
     * @Description 根据书的二级类别查找商品
     * @Date 2019/6/4 16:25
     * @param 
     * @return 
     */
    PageInfo<BookInfo> findByBookCategoryIdSecond(Integer bookCategoryId, Integer pageNo, Integer pageSize);
}
