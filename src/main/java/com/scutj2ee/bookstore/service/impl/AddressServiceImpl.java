package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.AddressDao;
import com.scutj2ee.bookstore.entity.Address;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/9 23:16
 * @description:
 */
@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressDao addressDao;

    @Override
    public int create(Address address) {
        return addressDao.insertAddress(address);
    }

    @Override
    public Address findByIdAndUserId(Integer id, Integer userId) {
        return addressDao.findByIdAndUserId(id, userId);
    }

    @Override
    public Address findAddressById(Integer id) {
        return addressDao.findAddressById(id);
    }


    @Override
    public List<Address> findByUserId() {

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
