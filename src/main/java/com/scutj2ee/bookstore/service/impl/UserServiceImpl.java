package com.scutj2ee.bookstore.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.dao.UserDao;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.enums.SystemErrorEnum;
import com.scutj2ee.bookstore.enums.UserResultEnum;
import com.scutj2ee.bookstore.exception.CustomException;
import com.scutj2ee.bookstore.exception.UserException;
import com.scutj2ee.bookstore.model.UserResult;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.MailUtil;
import com.scutj2ee.bookstore.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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
    public User getUserById(Integer userId) {
        return userDao.findUserById(userId);
    }

//    @Override
//    public PageInfo<User> selectAll(Integer pageNo, Integer pageSize) {
//        return userDao.selectAll();
//    }

    @Override
    public int insert(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public UserResult updateUser(User user) {
        UserResult userResult = new UserResult();
        if (user == null) {
            userResult.setCode(UserResultEnum.INPUT_NULL.getCode());
            userResult.setMsg(UserResultEnum.INPUT_NULL.getMsg());
            return userResult;
        }
        try {
            //调用dao层更新数据
            int result = userDao.updateUser(user);
            if (result == 1){
                userResult.setCode(UserResultEnum.SUCCESS.getCode());
                userResult.setMsg(UserResultEnum.SUCCESS.getMsg());
            } else {
                userResult.setCode(UserResultEnum.FAILD.getCode());
                userResult.setMsg(UserResultEnum.FAILD.getMsg());
            }
            return userResult;
        }catch (Exception e){
            throw new UserException(SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg(), SystemErrorEnum.SYSTEM_INNER_ERROR.getCode());
        }
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteUser(id);
    }

    @Override
    public UserResult userExitOrNot(String username) {
        UserResult userResult = new UserResult();
        if (username == null) {
            userResult.setCode(UserResultEnum.INPUT_NULL.getCode());
            userResult.setMsg(UserResultEnum.INPUT_NULL.getMsg());
            return userResult;
        }
        try {
            User user = userDao.findByUsername(username);
            if (user == null) {
                userResult.setCode(UserResultEnum.USER_NOT_EXIT.getCode());
                userResult.setMsg(UserResultEnum.USER_NOT_EXIT.getMsg());
            } else {
                userResult.setCode(UserResultEnum.SUCCESS.getCode());
                userResult.setMsg(UserResultEnum.SUCCESS.getMsg());
                //设置user返回个前端使用
                userResult.setUser(user);
            }
            return userResult;
        } catch (Exception e) {
            throw new UserException(SystemErrorEnum.SYSTEM_INNER_ERROR.getMsg(), SystemErrorEnum.SYSTEM_INNER_ERROR.getCode());
        }
    }

    @Override
    public PageInfo<User> getUserList(Integer pageNo, Integer pageSize) {
        pageNo = pageNo == -1 ? 1 : pageNo;
        pageSize = pageSize == -1 ? 10 : pageSize;
        List<User> list = userDao.getUserListByParams();
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return pageInfo;
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
}
