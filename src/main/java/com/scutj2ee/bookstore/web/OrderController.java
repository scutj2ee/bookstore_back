package com.scutj2ee.bookstore.web;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.entity.OrderItem;
import com.scutj2ee.bookstore.service.OrderService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author: kevin
 * @data: 2019/6/1 13:20
 * @description: 订单控制层
 */
@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 查看用户的订单
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public HashMap<String, Object> listOrder(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer userId;
        try{
            userId = HttpServletRequestUtil.getInt(request, "userId");
        }catch (NumberFormatException e){
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID异常");
            return resultMap;
        }
        PageInfo<Order> pageInfo = orderService.findUserOrder(userId, pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("totalData", pageInfo == null? null : pageInfo.getList());
        return resultMap;
    }

    /**
     * 查询订单详情
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/getDetail")
    public HashMap<String, Object> getDetail(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer orderId;
        try{
            orderId = HttpServletRequestUtil.getInt(request, "orderId");
        }catch (NumberFormatException e){
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID异常");
            return resultMap;
        }
        PageInfo<OrderItem> pageInfo = orderService.findItems(orderId, pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("totalData", pageInfo == null ? null : pageInfo.getList());
        return resultMap;
    }

    /**
     * 确认收货
     * @param request
     * @return
     */
    @RequestMapping("/receive")
    public HashMap<String, Object> receive(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer userId;
        try{
            userId = HttpServletRequestUtil.getInt(request, "userId");
        }catch (NumberFormatException e){
            resultMap.put("success", false);
            resultMap.put("msg", "获取用户对象ID异常");
            return resultMap;
        }
        orderService.receive(userId);
        resultMap.put("success", true);
        resultMap.put("msg", "确认收货成功");
        return resultMap;
    }

    /**
     * 提交订单
     */

    /**
     * 支付
     */

}