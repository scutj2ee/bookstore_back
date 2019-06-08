package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.BookCategoryDao;
import com.scutj2ee.bookstore.entity.BookCategory;
import com.scutj2ee.bookstore.model.dto.BookCategoryDto;
import com.scutj2ee.bookstore.service.BookCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<BookCategory> findAllFirst() {
        return bookCategoryDao.selectAll();
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
    public List<BookCategory> findCategorySecond(Integer parentId) {
        return bookCategoryDao.findByParentId(parentId);
    }

    @Override
    public List<BookCategoryDto> findAll() {
        //创建类目传输类序列
        List<BookCategoryDto> list=new ArrayList<>();
        //获取所有的1级类目
        List<BookCategory> bookCategoryList=bookCategoryDao.selectAll();
        for(BookCategory category:bookCategoryList){
            //创建类目传输类
            BookCategoryDto bookCategoryDto=new BookCategoryDto();
            //设置一级类目
            bookCategoryDto.setId(category.getId());
            bookCategoryDto.setName(category.getName());
            //设置一级类目对应的所有二级类目
            List<BookCategory> second=bookCategoryDao.findByParentId(category.getId());
            List<BookCategoryDto> list1=new ArrayList<>();
            for (BookCategory bookCategory:second){
                //创建类目传输类
                BookCategoryDto bookCategoryDto1=new BookCategoryDto();
                bookCategoryDto1.setId(bookCategory.getId());
                bookCategoryDto1.setName(bookCategory.getName());
                list1.add(bookCategoryDto1);
            }
            bookCategoryDto.setChild(list1);
            list.add(bookCategoryDto);
        }
        return list;
    }
}
