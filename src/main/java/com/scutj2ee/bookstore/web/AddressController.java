package com.scutj2ee.bookstore.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Address;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.service.AddressService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author ：Bin Liu
 * @Date ：2019/5/25 10:17
 * @Description：地址管理类
 * @Modified By：
 */
@RestController
@RequestMapping("address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * create by: Bin Liu
     * description: 查询该用户id所有地址
     * create time: 2019/5/23 9:24
     *
     * @return
     * @Param: null
     */
    @RequestMapping("/list")
    private HashMap<String, Object> listLeads(HttpServletRequest request, Integer pageNo, Integer pageSize) {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.获取前端传递的userId参数
        Integer userId = HttpServletRequestUtil.getInt(request, "userId");
        PageInfo<Address> pageInfo = addressService.getAddressList(userId, pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("tableData", pageInfo == null ? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? 0 : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * create by: Bin Liu
     * description: 增加用户地址
     * create time: 2019/5/25 10:39
     *
     * @return
     * @Param: null
     */
    @PostMapping("/add")
    public HashMap<String, Object> addAddress(HttpServletRequest request) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成Address对象
        String addressStr = HttpServletRequestUtil.getString(request, "address");
        ObjectMapper mapper = new ObjectMapper();
        Address address = mapper.readValue(addressStr, Address.class);
        try {
            int result = addressService.create(address);
            if (result > 0) {
                resultMap.put("success", true);
                resultMap.put("msg", "增加地址成功");
            } else {
                resultMap.put("success", false);
            }
            return resultMap;
        } catch (SystemException ex) {
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
            return resultMap;
        }
    }

    /**
     * create by: Bin Liu
     * description: 用户修改地址信息
     * create time: 2019/5/25 10:42
     *
     * @return
     * @Param: null
     */
    @PostMapping("/update")
    public HashMap<String, Object> changeAddress(HttpServletRequest request) throws Exception {
        HashMap<String, Object> resultMap = new HashMap<>();
        //1.将前台获取的参数转换成Address对象
        String addressStr = HttpServletRequestUtil.getString(request, "address");
        ObjectMapper mapper = new ObjectMapper();
        Address address = mapper.readValue(addressStr, Address.class);
        try {
            int result = addressService.update(address);
            if (result > 0) {
                resultMap.put("success", true);
                resultMap.put("msg", "修改地址成功");
            } else {
                resultMap.put("success", false);
            }
            return resultMap;
        } catch (SystemException ex) {
            resultMap.put("success", false);
            resultMap.put("code", ex.getCode());
            resultMap.put("msg", ex.getMessage());
            return resultMap;
        }
    }

    /**
     * create by: Bin Liu
     * description: 根据地址Id删除地址
     * create time: 2019/5/23 15:37
     *
     * @return
     * @Param: null
     */
    @DeleteMapping("/delete")
    public HashMap<String, Object> deleteAddress(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer id = HttpServletRequestUtil.getInt(request, "id");
        try {
            int result = addressService.deleteById(id);
            if (result == 0) {
                resultMap.put("success", false);
                resultMap.put("msg", "删除失败");
            } else {
                resultMap.put("success", true);
                resultMap.put("msg", "删除成功");
            }
        } catch (RuntimeException e) {
            resultMap.put("success", false);
            resultMap.put("msg", e.getMessage());
        }
        return resultMap;
    }
}
