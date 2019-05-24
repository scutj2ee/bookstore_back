package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.service.MailService;
import com.scutj2ee.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/29 22:49
 * @ Description：注册控制器类
 * @ Modified By：
 */
@RestController
@RequestMapping("")
public class RegisterController {
    @Autowired
    private MailService mailService;

    @Autowired
    private UserService userService;

    /**
    * create by: Bin Liu
    * description: 发送邮件验证码
    * create time: 2019/5/24 14:44
    * @Param: null
    * @return 
    */
    @PostMapping("code")
    public ResponseEntity<String> senVerifyCode(@RequestParam("eamil") String email){
        String code = this.userService.sendVerifyCode(email);
        if (code == null || code.equals("")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(code);
    }

    /**
     * create by: Bin Liu
     * description: 注册
     * create time: 2019/5/24 14:44
     * @Param: null
     * @return 
     */
    @PostMapping("register")
    public ResponseEntity<Void> register(@Valid User user, @RequestParam("code") String code){
        Boolean result = this.userService.register(user,code);
        if(result == null || !result){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    /**
     * 用户验证
     * @param username
     * @param password
     * @return
     */
    @GetMapping("query")
    public ResponseEntity<User> queryUser(@RequestParam("username")String username,@RequestParam("password")String password){
        User user = this.userService.queryUser(username,password);
        if (user == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(user);
    }
}
