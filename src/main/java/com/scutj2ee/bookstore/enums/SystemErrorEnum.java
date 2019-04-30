package com.scutj2ee.bookstore.enums;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 10:49
 * @ Description：系统错误枚举类
 * @ Modified By：
 */
public enum SystemErrorEnum {
    SYSTEM_INNER_ERROR(-1001,"系统内部错误,操作失败"),
    KAPTCHA_INPUT_ERROR(-1002,"验证码输入错误"),
    CAPTCHA_GET_SUCCESS(1,"验证码获取成功"),
    INPUT_NULL_ERROR(-1003,"信息输入为空"),
    FILE_EXTENSION_ERROR(-1004,"文件格式有误");

    private Integer code;
    private String msg;

    SystemErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
