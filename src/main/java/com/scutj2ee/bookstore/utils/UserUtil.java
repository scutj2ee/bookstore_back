/*
package com.scutj2ee.bookstore.utils;

import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.CustomException;
import com.scutj2ee.bookstore.model.common.Constant;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

*/
/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 9:48
 * @ Description：获取当前登录用户工具类
 * @ Modified By：
 *//*

@Component
public class UserUtil {
    private final UserDao userDao;

    @Autowired
    public UserUtil(UserDao userDao) {
        this.userDao = userDao;
    }

    */
/**
     * create by: Bin Liu
     * description: 获取当前登录用户
     * create time: 2019/5/24 9:54
     * @Param: null
     * @return 
     *//*

    public User getUser() {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        // 解密获得username
        String username = JwtUtil.getClaim(token, Constant.USERNAME);
        User user =new User();
        user = userDao.findByUsername(username);
        // 用户是否存在
        if (user == null) {
            throw new CustomException("该帐号不存在(The username does not exist.)");
        }
        return user;
    }

    */
/**
     * create by: Bin Liu
     * description: 获取当前登录用户Id
     * create time: 2019/5/24 9:54
     * @Param: null
     * @return 
     *//*

    public Integer getUserId() {
        return getUser().getId();
    }

    */
/**
     * create by: Bin Liu
     * description: 获取当前登录用户Token
     * create time: 2019/5/24 9:54
     * @Param: null
     * @return 
     *//*

    public String getToken() {
        return SecurityUtils.getSubject().getPrincipal().toString();
    }

    */
/**
     * create by: Bin Liu
     * description: 获取当前登录用户username
     * create time: 2019/5/24 9:57
     * @Param: null
     * @return
     *//*

    public String getUsername() {
        String token = SecurityUtils.getSubject().getPrincipal().toString();
        // 解密获得username
        return JwtUtil.getClaim(token, Constant.USERNAME);
    }
}
*/
