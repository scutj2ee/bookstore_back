package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.Address;
import com.scutj2ee.bookstore.pojo.ResultBean;
import com.scutj2ee.bookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/5/9 23:34
 * @description:
 */
@RestController
@RequestMapping("")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 地址管理页面
     */
    @RequestMapping("/toAddress")
    public String toAddressList(){
        return "/address/list";
    }

    /**
     *
     */
    @ResponseBody
    @RequestMapping("/list")
    public String toEditAddress(){
        return "/address/edit";
    }


}
