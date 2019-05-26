package com.scutj2ee.bookstore.web.admin;

import com.scutj2ee.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
