package com.ddos.pizza.common;

public class Constant {
    private Constant() {
    }

    public static final int RES_SUCCESS = 200;
    //账号或者密码错误
    public static final int RES_LOGIN_INAVLID = 50001;
    public static final String RES_LOGIN_INAVLID_MESSAGE = "账号或者密码错误";
    //TOKEN问题
    public static final int RES_TOKEN_INAVLID = 50011;
    public static final String RES_TOKEN_INAVLID_MESSAGE = "TOKEN问题";
    //名称已经存在
    public static final int RES_USER_NAME_REPEAT = 50002;
    public static final String RES_USER_NAME_REPEAT_MESSAGE = "名称已经存在";
    //手机号已经存在
    public static final int RES_USER_PHONE_REPEAT = 50003;
    public static final String RES_USER_PHONE_REPEAT_MESSAGE = "手机号已经存在";

    public static final int RES_LOGIN_FAIL = 50004;
}
