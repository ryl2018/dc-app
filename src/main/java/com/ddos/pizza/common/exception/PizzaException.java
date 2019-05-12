package com.ddos.pizza.common.exception;

public class PizzaException extends Exception implements PizzaError {
    private static final long serialVersionUID = 1L;

    private ErrorEnum errorEnum;
    private Object obj;

    public ErrorEnum getError() {
        return errorEnum;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public PizzaException(ErrorEnum errorEnum){
        super();
        this.errorEnum = errorEnum;
    }
    public PizzaException(ErrorEnum errorEnum,Object obj){
        this.obj = obj;
        this.errorEnum = errorEnum;
    }

    public PizzaException(ErrorEnum errorEnum,String message){
        super(message);
        this.errorEnum = errorEnum;
    }

    public PizzaException(ErrorEnum errorEnum,Throwable cause){
        super(cause);
        this.errorEnum = errorEnum;
    }

    public PizzaException(ErrorEnum errorEnum,String message,Throwable cause){
        super(message,cause);
        this.errorEnum = errorEnum;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();
        return errorEnum.getMessage() + (message != null ? (":" + message) : "");
    }

    @Override
    public String getErrorCode() {
        return this.errorEnum.getCode();
    }

    @Override
    public String getErrorMessage() {
        return this.getMessage();
    }

    @Override
    public Object getErrorData() {
        return this.obj;
    }
}
