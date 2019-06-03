package com.scutj2ee.bookstore.exception;

import com.scutj2ee.bookstore.enums.OrderExceptionEnum;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/6/3 10:52
 * @ Description：${description}
 * @ Modified By：
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(OrderExceptionEnum orderExceptionEnum){
        super(orderExceptionEnum.getMsg());
        this.code = orderExceptionEnum.getCode();
    }

    public OrderException(){ }

    public Integer getCode() {
        return code;
    }
}
