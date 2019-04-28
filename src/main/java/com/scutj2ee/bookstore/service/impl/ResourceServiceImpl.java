package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.ResourceDao;
import com.scutj2ee.bookstore.entity.Resource;
import com.scutj2ee.bookstore.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/28 10:29
 * @ Description：${description}
 * @ Modified By：
 */
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    private ResourceDao resourceDao;

    @Override
    public List<Resource> findByRoleId(int roleId) {
        return resourceDao.findByRoleId(roleId);
    }
}
