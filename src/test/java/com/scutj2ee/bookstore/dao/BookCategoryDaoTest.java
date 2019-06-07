package com.scutj2ee.bookstore.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/7 22:49
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BookCategoryDaoTest {
    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Test
    public void selectAll() {
        bookCategoryDao.selectAll();
    }
}