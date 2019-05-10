package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.Address;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/9 20:19
 * @description:
 */

@Component
public interface AddressService {
    /**
     * 创建一个地址
     */
    int create(Address address);

    /**
     * 查询地址
     */
    Address findByIdAndUserId(Integer id, Integer userId);

    Address findAddressById(Integer id);


    /**
     * 查询用户所有相关的地址
     */
    List<Address> findByUserId(HttpServletRequest request);

    /**
     * 更新一个地址
     */
    void update(Address address);

    /**
     * 删除一个地址
     */
    void deleteById(Integer id);
}
