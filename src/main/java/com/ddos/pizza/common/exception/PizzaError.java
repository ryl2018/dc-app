package com.ddos.pizza.common.exception;
/**
 * 通用异常接口。
 */
public interface PizzaError {
    /**
     * 错误编码。
     * @return
     */
    String getErrorCode();

    /**
     * 错误描述。
     * @return
     */
    String getErrorMessage();

    /**
     * 错误数据。
     * @return
     */
    Object getErrorData();
}
