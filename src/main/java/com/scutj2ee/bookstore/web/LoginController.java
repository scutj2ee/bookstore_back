package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.CustomUnauthorizedException;
import com.scutj2ee.bookstore.model.common.Constant;
import com.scutj2ee.bookstore.model.common.ResponseBean;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/3 9:45
 * @ Description：登陆控制器类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class LoginController {
    /**
     * RefreshToken过期时间
     */
    @Value("${refreshTokenExpireTime}")
    private String refreshTokenExpireTime;

    private final UserUtil userUtil;

    @Autowired
    private UserService userService;

    @Autowired
    public LoginController(UserUtil userUtil) {
        this.userUtil = userUtil;
    }

    /**
     * create by: Bin Liu
     * description: 登录授权
     * create time: 2019/5/24 14:24
     * @Param: null
     * @return 
     */
    @PostMapping("/login")
    public ResponseBean login(@Validated @RequestBody User user, HttpServletResponse httpServletResponse) {
        // 查询数据库中的帐号信息
        User userTemp = new User();
        userTemp = userService.findByUsername(user.getUsername());
        if (userTemp == null) {
            throw new CustomUnauthorizedException("该帐号不存在(The account does not exist.)");
        }
        // 密码进行AES解密
        String key = AesCipherUtil.deCrypto(userTemp.getPassword());
        // 因为密码加密是以帐号+密码的形式进行加密的，所以解密后的对比是帐号+密码
        if (key.equals(user.getUsername() + user.getPassword())) {
            // 清除可能存在的Shiro权限信息缓存
            if (JedisUtil.exists(Constant.PREFIX_SHIRO_CACHE + user.getUsername())) {
                JedisUtil.delKey(Constant.PREFIX_SHIRO_CACHE + user.getUsername());
            }
            // 设置RefreshToken，时间戳为当前时间戳，直接设置即可(不用先删后设，会覆盖已有的RefreshToken)
            String currentTimeMillis = String.valueOf(System.currentTimeMillis());
            JedisUtil.setObject(Constant.PREFIX_SHIRO_REFRESH_TOKEN + user.getUsername(), currentTimeMillis, Integer.parseInt(refreshTokenExpireTime));
            // 从Header中Authorization返回AccessToken，时间戳为当前时间戳
            String token = JwtUtil.sign(user.getUsername(), currentTimeMillis);
            httpServletResponse.setHeader("Authorization", token);
            httpServletResponse.setHeader("Access-Control-Expose-Headers", "Authorization");
            return new ResponseBean(HttpStatus.OK.value(), "登录成功(Login Success.)", null);
        } else {
            throw new CustomUnauthorizedException("帐号或密码错误(Account or Password Error.)");
        }
    }
}
