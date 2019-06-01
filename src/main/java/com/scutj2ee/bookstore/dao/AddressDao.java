package com.scutj2ee.bookstore.dao;

import com.scutj2ee.bookstore.entity.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface AddressDao {
    int deleteAddress(Integer id);

    int insertAddress(Address address);

    Address findAddressById(Integer id);

    List<Address> selectAll();

    int updateAddress(Address address);

    Address findByIdAndUserId(Integer id, Integer userId);

    List<Address> findByUserId(Integer userId);

    List<Address> getAddressListByParams(Map map);
}