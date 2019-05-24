package com.scutj2ee.bookstore.service.impl;

import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.CustomException;
import com.scutj2ee.bookstore.exception.CustomUnauthorizedException;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.AesCipherUtil;
import com.scutj2ee.bookstore.utils.MailUtil;
import com.scutj2ee.bookstore.utils.RandomUtil;
import com.scutj2ee.bookstore.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/27 23:03
 * @ Description：${description}
 * @ Modified By：
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private MailUtil mailUtil;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User getUserById(int userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public int insert(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public int update(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User queryUser(String username, String password) {
        //1.查询用户
        User user = new User();
        user=userDao.findByUsernameAndPassword(username,password);
        //2.校验用户名
        if (user == null){
            return null;
        }
        //3. 校验密码
        // 密码进行AES解密
        String key = AesCipherUtil.deCrypto(user.getPassword());
        if (!key.equals(user.getUsername() + password)){
            return null;
        }
        //4.用户名密码都正确
        return user;
    }

    @Override
    public String sendVerifyCode(String email) {
        //1.生成验证码
        String checkCode = RandomUtil.getRandomVerCode();
        String message = "您的注册验证码为：" + checkCode;
        //3.发送邮件
        try {
            mailUtil.sendSimpleMail(email, "注册验证码", message);
        } catch (Exception e) {
            throw new CustomException("发送邮箱验证码失败");
        }
        return checkCode;
    }

    @Override
    public Boolean register(User user, String code) {
        // 1.查询数据库中的帐号信息
        User userTemp = new User();
        userTemp = userDao.findByUsername(user.getUsername());
        if (userTemp != null) {
            throw new CustomUnauthorizedException("该帐号已存在(The account already exist.)");
        }
        //2. 密码进行AES解密
        String key = AesCipherUtil.deCrypto(userTemp.getPassword());
        //3.写入数据库
        int count = this.userDao.insertUser(user);
        if (count <= 0) {
            return false;
        }
        return true;
    }
}
