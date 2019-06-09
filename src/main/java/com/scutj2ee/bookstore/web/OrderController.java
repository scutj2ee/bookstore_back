package com.scutj2ee.bookstore.web;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.entity.OrderItem;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.model.dto.CommentBookDto;
import com.scutj2ee.bookstore.model.dto.OrderDto;
import com.scutj2ee.bookstore.service.OrderService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * @author: kevin
 * @data: 2019/6/1 13:20
 * @description: 订单控制层
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * create by: Bin Liu
     * description: 查看用户的所有订单
     * create time: 2019/6/3 20:03
     * @param request
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/list")
    public HashMap<String, Object> listOrder(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer userId = HttpServletRequestUtil.getInt(request, "userId");
        PageInfo<OrderDto> pageInfo = orderService.findUserOrder(userId, pageNo, pageSize);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("totalData", pageInfo == null? null : pageInfo.getList());
        resultMap.put("total", pageInfo == null ? 0 : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * @Author Bin Liu
     * @Description 查询订单详情
     * @Date 2019/6/4 14:32
     * @param request
     * @return
     */
    @RequestMapping("/getDetail")
    public HashMap<String, Object> getDetail(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer orderId= HttpServletRequestUtil.getInt(request, "orderId");
        List<OrderItem> orderItems = orderService.findItems(orderId);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("orderItems", orderItems);
        return resultMap;
    }

    /**
     * @Author Bin Liu
     * @Description 生成订单
     * @Date 2019/6/4 14:41
     * @param request
     *
     * @return 
     */
    @RequestMapping("/submit")
    public HashMap<String, Object> submit(HttpServletRequest request,@RequestParam(value = "cartIdList[]") List<Integer> cartIdList){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer userId= HttpServletRequestUtil.getInt(request, "userId");
        Integer addressId= HttpServletRequestUtil.getInt(request, "addressId");
        try {
            int result = orderService.submit(userId,addressId,cartIdList);
            if (result > 0) {
                resultMap.put("success", true);
                resultMap.put("msg", "提交成功");
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
     * @Author Bin Liu
     * @Description 付款
     * @Date 2019/6/4 15:42
     * @param
     * @return
     */
    @RequestMapping("/pay")
    public HashMap<String, Object> pay(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer orderId= HttpServletRequestUtil.getInt(request, "orderId");
        Integer userId= HttpServletRequestUtil.getInt(request, "userId");
        try {
            int result = orderService.pay(orderId,userId);
            if (result > 0) {
                resultMap.put("success", true);
                resultMap.put("msg", "付款成功");
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
     * description: 确认收货
     * create time: 2019/6/3 20:18
     * @Param: null
     * @return 
     */
    @RequestMapping("/receive")
    public HashMap<String, Object> receive(HttpServletRequest request){
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer orderId = HttpServletRequestUtil.getInt(request, "orderId");
        orderService.receive(orderId);
        resultMap.put("success", true);
        resultMap.put("msg", "确认收货成功");
        return resultMap;
    }

    /**
     * @Author Bin Liu
     * @Description 获取该订单下的所有书本
     * @Date 2019/6/5 12:34
     * @param request
     * @return
     */
    @RequestMapping("/orderBook")
    private HashMap<String, Object> getAllBook(HttpServletRequest request) {
        HashMap<String, Object> resultMap = new HashMap<>();
        Integer orderId= HttpServletRequestUtil.getInt(request, "orderId");
        List<CommentBookDto> bookList=orderService.getBookList(orderId);
        resultMap.put("success", true);
        resultMap.put("msg", "获取成功");
        resultMap.put("bookList", bookList);
        return resultMap;
    }
}
