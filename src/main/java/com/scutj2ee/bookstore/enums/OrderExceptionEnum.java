package com.scutj2ee.bookstore.enums;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/3 10:52
 * @ Description：注册结果枚举类
 * @ Modified By：
 */
public enum OrderExceptionEnum {
    createOrder_error(201,"创建订单失败"),
    createOrderProductDeatil_error(202,"创建订单商品详情失败"),
    orderId_error(203,"订单编号错误"),
    orderValidt_error(204,"支付验证错误"),
    orderUpdateState_error(205,"更新订单状态错误"),
            ;

    private Integer code;
    private String msg;

    OrderExceptionEnum(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
