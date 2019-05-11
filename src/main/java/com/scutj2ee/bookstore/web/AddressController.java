package com.scutj2ee.bookstore.web;

import com.scutj2ee.bookstore.entity.Address;
import com.scutj2ee.bookstore.entity.User;
import com.scutj2ee.bookstore.exception.LoginException;
import com.scutj2ee.bookstore.pojo.ResultBean;
import com.scutj2ee.bookstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
     * 增加地址页面
     */
    @RequestMapping("/toAdd")
    public String toAddAddress(){
        return "/address/add";
    }

    /**
     * 修改地址页面
     */
    @RequestMapping("/toEdit")
    public String toEditAddress(int id, Map<String, Object> map){
        Address address = addressService.findAddressById(id);
        map.put("address", address);
        return "/address/edit";
    }

    /**
     * 展现用户的地址
     */
    @RequestMapping("/list")
    public ResultBean<List<Address>> list(HttpServletRequest request){
        List<Address> addresses = addressService.findByUserId(request);
        return new ResultBean<>(addresses);
    }

    /**
     * 增加用户地址
     */
    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public void addAddress(String province, String city, String district, String detail,
                           String receiver, Integer phone, HttpServletRequest request,
                           HttpServletResponse response)throws Exception{
        Address address = new Address();
        Object user = request.getSession().getAttribute("user");
        if(user == null){
            throw new LoginException("请登录！");
        }
        User loginUser = (User) user;
        address.setId(loginUser.getId());
        address.setProvince(province);
        address.setCity(city);
        address.setDistrict(district);
        address.setDetail(detail);
        address.setPhone(phone);
        address.setReceiver(receiver);
        int id = addressService.create(address);
        if(id <= 0){
            request.getSession().setAttribute("message", "添加失败！");
            request.getRequestDispatcher("toAdd").forward(request, response);
        }
        else{
            request.getRequestDispatcher("toAddress").forward(request, response);
        }
    }

    /**
     * 用户修改地址信息
     * 有问题：有时传入id为Integer,有时是int
     */
    @ResponseBody
    @RequestMapping("/edit")
    public ResultBean<Boolean> changeAddress(Integer id, String province, String city,
                                             String district, String detail, String receiver,
                                             Integer phone, HttpServletRequest request,
                                             HttpServletResponse response)throws Exception{
        Address address = addressService.findAddressById(id);
        address.setProvince(province);
        address.setCity(city);
        address.setDistrict(district);
        address.setDetail(detail);
        address.setReceiver(receiver);
        address.setPhone(phone);
        addressService.update(address);
        return new ResultBean<>(true);
    }

    /**
     * 删除地址
     */
    @ResponseBody
    @RequestMapping("/del")
    public ResultBean<Boolean> deleteAddress(Integer id){
        addressService.deleteById(id);
        return new ResultBean<>(true);
    }


}
