package com.first_spring_demo.common.exception;

/**
 * @author wxd
 */
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
