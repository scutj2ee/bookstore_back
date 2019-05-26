package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.BookCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookCategoryDao {
    int deleteBookCategory(Integer cateId);

    int insertBookCategory(BookCategory bookCategory);

    BookCategory findBookCategoryById(Integer cateId);

    List<BookCategory> selectAll();

    int updateBookCategory(BookCategory bookCategory);

    List<BookCategory> findByType(Integer type);

    List<BookCategory> findByParentId(Integer parentId);

    List<BookCategory> getBookCategoryListByParams();
}