package com.scutj2ee.bookstore.exception;

/**
 * @Author kobe
 * @Date 2019/4/25 11:26
 * @Description:登录异常处理
 * @Modified By: Liu Bin
 */
public class LoginException extends RuntimeException {
    private Integer code;

    public LoginException() {
    }

    public LoginException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

    public LoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
