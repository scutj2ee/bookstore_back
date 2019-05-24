package com.scutj2ee.bookstore.service;

import com.scutj2ee.bookstore.entity.AdminUser;
import com.scutj2ee.bookstore.model.AdminUserResult;
import org.apache.ibatis.annotations.Param;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 20:53
 * @ Description：${description}
 * @ Modified By：
 */
public interface AdminUserService {
    /**
    * create by: Bin Liu
    * description: 根据id查管理员信息
    * create time: 2019/5/24 20:54
    * @Param: null
    * @return
    */
    AdminUser getAdminUserById(int id);

    /**
     * create by: Bin Liu
     * description: 根据传入的姓名和密码查找管理员
     * create time: 2019/5/24 20:57
     * @Param: null
     * @return
     */
    AdminUser getManager(@Param("userName") String userName, @Param("password")String password);

    /**
     * create by: Bin Liu
     * description: 根据传入的姓名判断管理员是否存在
     * create time: 2019/5/24 20:57
     * @Param: null
     * @return
     */
    AdminUserResult adminUserExitOrNot(String userName);

    /**
     * create by: Bin Liu
     * description: 根据传入的管理员信息更新管理员
     * create time: 2019/5/24 20:57
     * @Param: null
     * @return
     */
    AdminUserResult updateAdminUser(AdminUser adminUser);

    /**
     * create by: Bin Liu
     * description: 删除管理员信息
     * create time: 2019/5/24 20:58
     * @Param: null
     * @return
     */
    int deleteAdminUser(Integer id);
}
