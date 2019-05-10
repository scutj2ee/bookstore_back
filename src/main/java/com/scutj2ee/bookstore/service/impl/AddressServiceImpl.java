package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.AddressDao;
import com.scutj2ee.bookstore.entity.Address;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/9 23:16
 * @description:
 */
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public int create(Address address) {
        return addressDao.insertAddress(address);
    }

    @Override
    public Address findByIdAndUserId(Integer id, Integer userId) {
        return null;
    }

    @Override
    public Address findAddressById(Integer id) {
        return addressDao.findAddressById(id);
    }

    @Override
    public List<Address> findByUserId(HttpServletRequest request) {
//        Object user = request.getSession().getAttribute("user");
//        if(user == null){
//            throw new LoginException("请登录！");
//        }
//        User loginUser = (User) user;
//        List<Address> addresses = addressDao.findByUserId(loginUser.getId());//有问题
//        return addresses;
        return null;
    }

    @Override
    public void update(Address address) {
        addressDao.updateAddress(address);
    }

    @Override
    public void deleteById(Integer id) {
        addressDao.deleteAddress(id);
    }
}
