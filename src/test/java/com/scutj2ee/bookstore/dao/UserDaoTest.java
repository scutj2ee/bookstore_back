package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @ Author     ：Cillivian Lin
 * @ Date       ：2019/6/3 0003 13:12
 * @ Description：${description}
 * @ Modified By：
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {
    @Autowired
    private  UserDao dao;
    @Test
    public void insertUser(){
        User user=new User();
        user.setPassword( "123" );
        user.setIntegration( 0 );
        user.setUsername( "lsq" );
        user.setEmail( "h2ojeremy@hotmail.com" );
        user.setPhone( "15113597631" );
        dao.insertUser( user );
    }

}