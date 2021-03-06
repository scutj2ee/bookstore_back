package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.AdminUser;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.model.RegisterResult;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 21:18
 * @ Description：注册逻辑接口
 * @ Modified By：
 */
public interface RegisterService {
    /**
     * create by: Bin Liu
     * description: 用户注册
     * create time: 2019/5/24 21:19
     * @Param: null
     * @return
     */
    RegisterResult registerByUser(User user);

    /**
     * create by: Bin Liu
     * description: 管理员申请
     * create time: 2019/5/24 21:20
     * @Param: null
     * @return
     */
    RegisterResult applyByAdminUser(AdminUser adminUser);

}
