package com.cyl.it.product.exception;

import lombok.Data;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */

@Data
public class ProductException extends  RuntimeException {

    private static final long serialVersionUID = 8160230716219009999L;

    private Integer code;

    public ProductException(Integer code , String message) {
        super(message);
        this.code = code;
    }

    public ProductException(String message) {
        super(message);
    }
}
