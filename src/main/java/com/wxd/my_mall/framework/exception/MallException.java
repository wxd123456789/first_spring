package com.wxd.my_mall.framework.exception;

public class MallException extends RuntimeException {
    public MallException() {
        super();
    }

    public MallException(String message, Throwable cause) {
        super(message, cause);
    }

    public MallException(String message) {
        super(message);
    }

    public MallException(Throwable cause) {
        super(cause);
    }
}
