package com.scutj2ee.bookstore.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.CustomException;
import com.scutj2ee.bookstore.exception.CustomUnauthorizedException;
import com.scutj2ee.bookstore.model.common.BaseDto;
import com.scutj2ee.bookstore.model.common.Constant;
import com.scutj2ee.bookstore.model.common.ResponseBean;
import com.scutj2ee.bookstore.service.UserService;
import com.scutj2ee.bookstore.utils.AesCipherUtil;
import com.scutj2ee.bookstore.utils.UserUtil;
import com.scutj2ee.bookstore.utils.common.StringUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/28 10:39
 * @ Description：${description}
 * @ Modified By：
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    /**
     * create by: Bin Liu
     * description: 获取用户列表
     * create time: 2019/5/24 12:39
     * @Param: null
     * @return 
     */
    @GetMapping
    @RequiresPermissions(logical = Logical.AND, value = {"user:view"})
    public ResponseBean user(@Validated BaseDto baseDto) {
        if (baseDto.getPage() == null || baseDto.getRows() == null) {
            baseDto.setPage(1);
            baseDto.setRows(10);
        }
        PageHelper.startPage(baseDto.getPage(), baseDto.getRows());
        List<User> users = userService.selectAll();
        PageInfo<User> selectPage = new PageInfo<User>(users);
        if (users == null || users.size() <= 0) {
            throw new CustomException("查询失败(Query Failure)");
        }
        Map<String, Object> result = new HashMap<String, Object>(16);
        result.put("count", selectPage.getTotal());
        result.put("data", selectPage.getList());
        return new ResponseBean(HttpStatus.OK.value(), "查询成功(Query was successful)", result);
    }

    /**
     * create by: Bin Liu
     * description: 新增用户
     * create time: 2019/5/24 14:33
     * @Param: null
     * @return
     */
    @PostMapping
    @RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
    public ResponseBean add(@RequestBody User user) {
        // 判断当前帐号是否存在
        User userTemp = new User();
        userTemp = userService.findByUsername(user.getUsername());
        if (userTemp != null && StringUtil.isNotBlank(userTemp.getPassword())) {
            throw new CustomUnauthorizedException("该帐号已存在(Account exist.)");
        }
        // 密码以帐号+密码的形式进行AES加密
        if (user.getPassword().length() > Constant.PASSWORD_MAX_LEN) {
            throw new CustomException("密码最多15位(Password up to 15 bits.)");
        }
        String key = AesCipherUtil.enCrypto(user.getUsername() + user.getPassword());
        user.setPassword(key);
        int count = userService.insert(user);
        if (count <= 0) {
            throw new CustomException("新增失败(Insert Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "新增成功(Insert Success)", user);
    }

    /**
     * create by: Bin Liu
     * description: 更新用户
     * create time: 2019/5/24 14:36
     * @Param: null
     * @return
     */
    @PutMapping
    @RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
    public ResponseBean update(@RequestBody User user) {
        // 查询数据库密码
        User userTemp = new User();
        userTemp = userService.findByUsername(user.getUsername());
        if (userTemp == null) {
            throw new CustomUnauthorizedException("该帐号不存在(Account not exist.)");
        } else {
            user.setId(userTemp.getId());
        }
        // FIXME: 如果不一样就说明用户修改了密码，重新加密密码(这个处理不太好，但是没有想到好的处理方式)
        if (!userTemp.getPassword().equals(user.getPassword())) {
            // 密码以帐号+密码的形式进行AES加密
            if (user.getPassword().length() > Constant.PASSWORD_MAX_LEN) {
                throw new CustomException("密码最多15位(Password up to 15 bits.)");
            }
            String key = AesCipherUtil.enCrypto(user.getUsername() + user.getPassword());
            user.setPassword(key);
        }
        int count = userService.update(user);
        if (count <= 0) {
            throw new CustomException("更新失败(Update Failure)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "更新成功(Update Success)", user);
    }

    /**
     * create by: Bin Liu
     * description: 删除用户
     * create time: 2019/5/24 14:32
     * @Param: null
     * @return
     */
    @DeleteMapping("/{id}")
    @RequiresPermissions(logical = Logical.AND, value = {"user:edit"})
    public ResponseBean delete(@PathVariable("id") Integer id) {
        int count = userService.deleteById(id);
        if (count <= 0) {
            throw new CustomException("删除失败，ID不存在(Deletion Failed. ID does not exist.)");
        }
        return new ResponseBean(HttpStatus.OK.value(), "删除成功(Delete Success)", null);
    }
}
