package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.BookCategory;
import org.springframework.data.domain.Example;

import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/12 17:40
 * @description:
 */
public interface BookCategoryService {
    /**
     * 根据id查询
     */
    BookCategory findById(Integer id);

    /**
     * 按分类查询所有分类
     * dao还没写
     */
    List<BookCategory> findByType(Integer type);

    /**
     *  按条件查询
     *  dao还没写
     */
    List<BookCategory> findAllExample(Example<BookCategory> example);

    /**
     * 更新
     */
    void update(BookCategory bookCategory);

    /**
     * 创建
     */
    int create(BookCategory bookCategory);

    /**
     * 删除
     */
    void deleteById(Integer id);

    /**
     * 根据parentId查询，即根据一级分类id查找二级分类
     */
    List<BookCategory> findByParentId(int pid);
}
