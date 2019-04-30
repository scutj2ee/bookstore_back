package com.scutj2ee.bookstore.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 10:55
 * @ Description：封装系统异常类
 * @ Modified By：
 */
public class SystemException extends RuntimeException{
    private Integer code;

    public SystemException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
