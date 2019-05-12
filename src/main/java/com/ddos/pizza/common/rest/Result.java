package com.ddos.pizza.common.rest;

import com.ddos.pizza.common.Constant;

public class Result<T> {
    private String message;
    private int resCode;
    private T data;

    private Result(String msg,int resCode,T data) {
        this.resCode = resCode;
        this.message = msg;
        this.data = data;
    }

    public static <T> Result success(){
        return new Result<T>("成功", Constant.RES_SUCCESS,null);
    }
    public static <T> Result<T> success(String msg){
        return new Result<>(msg,Constant.RES_SUCCESS,null);
    }
    public static <T> Result<T> success(T data){
        return new Result<>("成功",Constant.RES_SUCCESS,data);
    }
    public static <T> Result<T> success(String msg,T data){
        return new Result<>(msg,Constant.RES_SUCCESS,data);
    }

    public static <T> Result<T> response(int resCode,String msg,T data){
        return new Result<>(msg,resCode,data);
    }

    public String getMessage() {
        return message;
    }

    public int getResCode() {
        return resCode;
    }

    public T getData() {
        return data;
    }
}
