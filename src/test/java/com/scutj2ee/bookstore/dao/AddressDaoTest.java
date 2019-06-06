package com.scutj2ee.bookstore.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/1 10:48
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class AddressDaoTest {
    @Autowired
    private AddressDao addressDao;

    @Test
    public  void findByUserId(){
        addressDao.findByUserId( 2 );
    }
    @Test
    public void deleteAddress() {
        addressDao.deleteAddress(1);
    }

    @Test
    public void selectAll(){
        addressDao.selectAll();
    }
}