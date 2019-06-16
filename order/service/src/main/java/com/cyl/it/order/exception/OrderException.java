package com.cyl.it.order.exception;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */

public class OrderException extends  RuntimeException {

    private Integer code;

    public OrderException(String message) {
        super(message);
    }

    public OrderException(Integer code , String message) {
        super(message);
        this.code = code;
    }
}
