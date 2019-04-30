package com.scutj2ee.bookstore.enums;

/**
 * @ Author     ：Bin Liu
 * @ Date       ：2019/4/30 10:50
 * @ Description：注册结果枚举类
 * @ Modified By：
 */
public enum RegisterResultEnum {
    INPUT_NULL(-1,"输入信息为空"),
    USER_EXIST(-2,"用户信息已存在"),
    SUCCESS(1,"注册成功"),
    APPLY_SUCCESS(2,"申请成功"),
    APPLY_REPEAT(-3,"重复申请，请等工作人员确认"),
    USER_FAILD(-4,"用户注册失败");

    private Integer code;
    private String msg;

    RegisterResultEnum(Integer code, String msg) {
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
