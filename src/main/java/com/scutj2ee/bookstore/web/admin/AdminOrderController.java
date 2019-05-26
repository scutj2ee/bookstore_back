package com.scutj2ee.bookstore.web.admin;

import com.github.pagehelper.PageInfo;
import com.scutj2ee.bookstore.entity.BookInfo;
import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.service.BookInfoService;
import com.scutj2ee.bookstore.service.OrderService;
import com.scutj2ee.bookstore.utils.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Author kobe
 * @Date 2019/5/25 16:46
 * @Description: 管理员对订单管理的业务
 * @Modified By:
 */

@RestController
@RequestMapping("/admin/order")
public class AdminOrderController {
    @Autowired
    private OrderService orderService;
    
    /**
     * create by: Bin Liu
     * description: 管理员查看所有订单
     * create time: 2019/5/26 15:16
     * @Param: null
     * @return 
     */
    @RequestMapping("/list")
    public HashMap<String, Object> getOrderList(HttpServletRequest request, Integer pageNo, Integer pageSize){
        HashMap<String, Object> resultMap = new HashMap<>();
        PageInfo<Order> pageInfo = orderService.getOrderList(pageNo,pageSize);
        resultMap.put("success",true);
        resultMap.put("msg","获取成功");
        resultMap.put("tableData",pageInfo == null ? null : pageInfo.getList() );
        resultMap.put("total", pageInfo == null ? null : pageInfo.getTotal());
        return resultMap;
    }

    /**
     * create by: Bin Liu
     * description: 管理员删除一个订单
     * create time: 2019/5/26 15:31
     * @Param: null
     * @return
     */
    @DeleteMapping("/delete")
    public HashMap<String, Object> delOrder(HttpServletRequest request){
        HashMap<String,Object> resultMap = new HashMap<>();
        Integer orderId = HttpServletRequestUtil.getInt(request,"orderId");
        try {
            int result = orderService.deleteById(orderId);
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

    /**
     * create by: Bin Liu
     * description: 管理员更新一个订单
     * create time: 2019/5/26 15:33
     * @Param: null
     * @return
     */
    @PutMapping("/update")
    public HashMap<String, Object> updateOrder(HttpServletRequest request, @RequestBody Order order) throws Exception{
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            int result=orderService.update(order);
            if (result>0) {
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
}
