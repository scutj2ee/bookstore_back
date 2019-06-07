package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.model.dto.BookCategoryDto;

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
     * @Author Bin Liu
     * @Description 找到所有的一级分类
     * @Date 2019/6/4 16:02
     * @param 
     * @return
     */
    List<BookCategory> findAllFirst();

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

    /**
     * @Author Bin Liu
     * @Description 通过一级类目id找到其对应的二级类目
     * @Date 2019/6/4 16:07
     * @param parentId
     * @return
     */
    List<BookCategory> findCategorySecond(Integer parentId);

    /**
     * @Author Bin Liu
     * @Description 获取所有的类目嵌套信息
     * @Date 2019/6/7 16:57
     * @param
     * @return
     */
    List<BookCategoryDto> findAll();
}
