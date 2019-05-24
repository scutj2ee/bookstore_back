package com.scutj2ee.bookstore.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 9:20
 * @ Description：自定义异常(CustomException)
 * @ Modified By：
 */
public class CustomException extends RuntimeException {

    public CustomException(String msg){
        super(msg);
    }

    public CustomException() {
        super();
    }
}
