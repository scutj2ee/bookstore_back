package com.scutj2ee.bookstore.service;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Address;
import com.scutj2ee.bookstore.entity.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    List<Address> findByUserId();

    /**
     * 更新一个地址
     */
    int update(Address address);

    /**
     * 删除一个地址
     */
    int deleteById(Integer id);

    /**
     * create by: Bin Liu
     * description: 分页查找地址列表
     * create time: 2019/5/25 10:30
     * @Param: null
     * @return
     */
    PageInfo<Address> getAddressList(Map map, Integer pageNo, Integer pageSize);
}
