package com.scutj2ee.bookstore.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/1 10:48
 * @ Description：${description}
 * @ Modified By：
 */
public class AddressDaoTest {
    @Autowired
    private AddressDao addressDao;

    @Test
    public void deleteAddress() {
        addressDao.deleteAddress(1);
    }

    @Test
    public void selectAll(){
        addressDao.selectAll();
    }
}