package com.tReAsures.demo.framework.enums;

/**
 * Created by Shuo LIANG
 */
public enum ResultEnum {
    PARAMS_ERROR(-1,"error request! please check your parameters！"),
    LOGIN_NAME(-1,"Login account error"),
    LOGIN_PASSWORD(-1,"Login password error"),
    LOGIN_NO(-3,"The user is not logged in"),
    SAVE_SERVICE(-1,"Save Failure"),
    ADD_SERVICE(-1,"Add Failure"),
    NAME_DUPLICATE(-3,"Sorry, the Service Name you entered has already existed!"),
    EXCEPTION_ERROR(-2,"bad request! Exception happens！"),
    INTERCEPTOR_OPERATION(-4,"unlogged in, operation was intercepted");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
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
