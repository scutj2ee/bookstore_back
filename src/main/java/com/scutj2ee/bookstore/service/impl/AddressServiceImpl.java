package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import java.util.Map;

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
    public int update(Address address) {
        return addressDao.updateAddress(address);
    }

    @Override
    public int deleteById(Integer id) {
        return addressDao.deleteAddress(id);
    }

    @Override
    public PageInfo<Address> getAddressList(Map map, Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<Address> list = addressDao.getAddressListByParams(map);
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Address> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
