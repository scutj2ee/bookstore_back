package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Address;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Address record);

    Address selectByPrimaryKey(Integer id);

    List<Address> selectAll();

    int updateByPrimaryKey(Address record);
}