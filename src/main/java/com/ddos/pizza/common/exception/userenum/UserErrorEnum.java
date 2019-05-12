package com.ddos.pizza.common.exception.userenum;

import com.ddos.pizza.common.exception.ErrorEnum;

public enum UserErrorEnum implements ErrorEnum {
    USER_1001("USER_1001","登陆失效"),
    USER_1002("USER_1002","操作违法"),
    USER_1003("USER_1003","用户名或者密码错误")
    ;
    private String code;
    private String message;
    UserErrorEnum(String code,String message){
        this.code = code;
        this.message = message;
    }
    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
