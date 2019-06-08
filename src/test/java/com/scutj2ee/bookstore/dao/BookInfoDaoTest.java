package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.BookInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
    public void insertBookInfo(){
        BookInfo bookInfo=new BookInfo();
        bookInfo.setBookId(1);
        bookInfo.setVersion("1");
        bookInfo.setTranslator("1");
        bookInfo.setPages(1);
        bookInfo.setMemberPrice(1.0);
        bookInfo.setIsShelf(1);
        bookInfo.setStoreTime(new Date());
        bookInfo.setStoreMount(1);
        bookInfo.setSize("1");
        bookInfo.setPublishDate(new Date());
        bookInfo.setPrice(1.0);
        bookInfo.setPress("1");
        bookInfo.setPackStyle("1");
        bookInfo.setOutline("1");
        bookInfo.setName("1");
        bookInfo.setMarketPrice(1.0);
        bookInfo.setLookMount(1);
        bookInfo.setIsbn("1");
        bookInfo.setImageUrl("1");
        bookInfo.setDetail("1");
        bookInfo.setDiscount(BigDecimal.ONE);
        bookInfo.setDealMount(1);
        bookInfo.setCatalog("1");
        bookInfo.setBookCategoryId(1);
        bookInfo.setAuthor("1");
        bookInfoDao.insertBookInfo(bookInfo);
    }

    @Test
    public void findByBookCategoryIdSecond(){
        bookInfoDao.findByBookCategoryId(1);
    }

    @Test
    public void getBookListParams() {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        bookInfoDao.getBookListParams(list);
    }
}