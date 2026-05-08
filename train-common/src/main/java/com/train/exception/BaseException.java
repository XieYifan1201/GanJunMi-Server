package com.train.exception;

/**
 * 业务异常类
 * 用于处理系统中的业务异常，统一异常信息格式
 */
public class BaseException extends RuntimeException {

    /**
     * 无参构造方法
     */
    public BaseException() {
        super();
    }

    /**
     * 带错误信息的构造方法
     * @param message 错误信息
     */
    public BaseException(String message) {
        super(message);
    }
}
