package com.scutj2ee.bookstore.crawl;

import com.scutj2ee.bookstore.dao.BookInfoDao;
import com.scutj2ee.bookstore.entity.BookInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class WriteToMysql {


    @Autowired
    private BookInfoDao bookInfoMapper;

    public void executeInsert(List<BookInfo> bookdatas) throws SQLException
    {
        long start = System.currentTimeMillis() / 1000;
        System.out.println(start);
        for (BookInfo bookdata : bookdatas) {
            bookInfoMapper.insertBookInfo(bookdata);
        }

        System.out.println("成功插入" + bookdatas.size() + "条");
        System.out.println(System.currentTimeMillis() / 1000);
        System.out.println(System.currentTimeMillis() / 1000 - start);
    }

}

