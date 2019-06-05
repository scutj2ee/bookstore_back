package com.scutj2ee.bookstore.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/4 19:25
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BookInfoDaoTest {
    @Autowired
    private BookInfoDao bookInfoDao;

    @Test
    public void getBookListParams() {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        bookInfoDao.getBookListParams(list);
    }
}