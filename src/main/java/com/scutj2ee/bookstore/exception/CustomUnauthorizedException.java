package com.scutj2ee.bookstore.exception;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/5/24 9:37
 * @ Description：自定义401无权限异常(UnauthorizedException)
 * @ Modified By：
 */
public class CustomUnauthorizedException extends RuntimeException {

    public CustomUnauthorizedException(String msg){
        super(msg);
    }

    public CustomUnauthorizedException() {
        super();
    }
}
