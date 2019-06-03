package com.scutj2ee.bookstore.web;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.scutj2ee.bookstore.config.AlipayConfig;
import com.scutj2ee.bookstore.entity.Order;
import com.scutj2ee.bookstore.enums.OrderExceptionEnum;
import com.scutj2ee.bookstore.exception.OrderException;
import com.scutj2ee.bookstore.exception.SystemException;
import com.scutj2ee.bookstore.service.OrderService;
import com.scutj2ee.bookstore.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/3 10:22
 * @ Description：支付控制器类
 * @ Modified By：
 */
@RequestMapping("/pay")
@RestController
public class PayController {
    @Autowired
    private PayService payService;

    @Autowired
    private OrderService orderService;

    @RequestMapping("/payment")
    public HashMap<String, Object> pay(
            @RequestParam("WIDout_trade_no") String out_trade_no,
            @RequestParam("WIDtotal_amount")String total_amount,
            @RequestParam("WIDsubject")String subject,
            @RequestParam("WIDbody")String body){
        HashMap<String, Object> resultMap = new HashMap<>();
        try {
            String result = payService.pay(out_trade_no,total_amount,subject,body);
            resultMap.put("success", true);
            resultMap.put("code", 1);
            resultMap.put("msg", "支付成功");
            resultMap.put("result",result);
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
     * description: 异步回调: 第三方支付接口发一个后台通知给商户平台，一般场景用户修改订单信息
     * create time: 2019/6/3 10:48
     * @Param: null
     * @return
     */
    @RequestMapping("/notify")
    public HashMap<String, Object> alipayNotifyNotice(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        HashMap<String, Object> resultMap = new HashMap<>();
        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            try {
                valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            params.put(name, valueStr);
        }

        //调用SDK验证签名
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        /** 实际验证过程建议商户务必添加以下校验：
        1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
        2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额），
        3、校验通知中的seller_id（或者seller_email) 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
        4、验证app_id是否为该商户本身。
        */
        //验证成功
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            //交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");

            if(trade_status.equals("TRADE_FINISHED")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                throw new OrderException(OrderExceptionEnum.orderValidt_error);
                //注意：
                //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            }else if (trade_status.equals("TRADE_SUCCESS")){
                //判断该笔订单是否在商户网站中已经做过处理
                //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                //如果有做过处理，不执行商户的业务程序
                Order order = orderService.findByOrderNo(out_trade_no);
                if (order == null){
                    throw new OrderException(OrderExceptionEnum.orderValidt_error);
                }
                int result = orderService.updateOrderByOrderNoAndPayNo(out_trade_no,trade_no);
                if (result != 1){
                    throw new OrderException(OrderExceptionEnum.orderUpdateState_error);
                }
                //注意：
                //付款完成后，支付宝系统发送该交易状态通知
            }
            resultMap.put("success", true);
            resultMap.put("code", 1);
            resultMap.put("msg", "成功");
            return resultMap;
        }else {//验证失败
            resultMap.put("success", false);
            resultMap.put("code", -2);
            resultMap.put("msg", "失败");
            return resultMap;
        }
        //验证失败
        /*if(!signVerified) {
            throw new OrderException(OrderExceptionEnum.orderValidt_error);
        }
        //商户订单号
        String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //支付宝交易号
        String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
        //交易状态
        String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"),"UTF-8");
        if(trade_status.equals("TRADE_FINISHED")){
            //判断该笔订单是否在商户网站中已经做过处理
            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            //如果有做过处理，不执行商户的业务程序
            //注意：
            //退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            throw new OrderException(OrderExceptionEnum.orderValidt_error);
        }else if (trade_status.equals("TRADE_SUCCESS")){
            //判断该笔订单是否在商户网站中已经做过处理
            //如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
            //如果有做过处理，不执行商户的业务程序
            //注意：
            //付款完成后，支付宝系统发送该交易状态通知
            //查询订单
            Order order = orderService.getOrderByOrderId(out_trade_no);
            if (order == null){
                throw new OrderException(OrderExceptionEnum.orderValidt_error);
            }
            int result = orderService.updateOrderSetPayNo(out_trade_no,trade_no);
            if (result != 1){
                throw new OrderException(OrderExceptionEnum.orderUpdateState_error);
            }
        }
        return ResultUtil.success();*/
    }

    /**
     * create by: Bin Liu
     * description: 同步回调: 整个支付流程完毕，使用同步方式将参数重定向给商户平台，一般场景用于展示结果。
     * create time: 2019/6/3 10:50
     * @Param: null
     * @return
     */
    @RequestMapping("/return")
    public HashMap<String, Object> alipayReturnNotice(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        HashMap<String, Object> resultMap = new HashMap<>();
        //获取支付宝GET过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        //调用SDK验证签名
        boolean signVerified = false;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
//        请求参数
        /*charset	utf-8
        out_trade_no	201905240015221558628122014
        method	alipay.trade.page.pay.return
                total_amount	1000.00
        sign	MWxowGai3PBppZTE6htFuJip6ewa3Y4d4AcCAc5lkWMMfx8+82h8443R/u2voWvQtpSnNhqrigJBOCjTPEnKJA+9zNKsIQRnejEhfHMIiUNEYnR9yK9zno6e53lL1hFGzIMuJGno4exukmula2yHtHlCLfGvG7tfN1boGQEY6rAwBI9najv5RqEKALt5LAP1DroHghJhgEzd8BttiMj9b8odRUVXVqC0PHpH6jttoCf2rQ4h/Y1seOMWto6pu2XgbQGcNTgYH9b/nirE9dvyZPcXMywmIvFi9HBknHg6YqeN8ZHrfvc52RHldFgDJKWrOMCz2TjL5ZiId0Pm3jRbQg==
                trade_no	2019052422001410481000045613
        auth_app_id	2016093000634497
        version	1.0
        app_id	2016093000634497
        sign_type	RSA2
        seller_id	2088102178009336
        timestamp	2019-05-24+00:16:16*/
        //——请在这里编写您的程序（以下代码仅作参考）——
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");

            Order order = new Order();
            order.setOrderNo(out_trade_no);
            order.setPayNo(trade_no);
            order.setPayment(Double.valueOf(total_amount));
            resultMap.put("success", true);
            resultMap.put("code", 1);
            resultMap.put("msg", "成功");
            return resultMap;
        }else {
            resultMap.put("success", false);
            resultMap.put("code", -2);
            resultMap.put("msg", "失败");
            return resultMap;
        }
    }
}
