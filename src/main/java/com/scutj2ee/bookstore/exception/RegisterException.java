package com.scutj2ee.bookstore.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 10:53
 * @ Description：注册逻辑异常类
 * @ Modified By：
 */
public class RegisterException extends RuntimeException{
    private Integer code;

    public RegisterException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
