package com.scutj2ee.bookstore.service;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/3 10:18
 * @ Description：支付业务逻辑接口
 * @ Modified By：
 */
public interface PayService {
    String pay(String out_trade_no, String total_amount, String subject, String body);
}
