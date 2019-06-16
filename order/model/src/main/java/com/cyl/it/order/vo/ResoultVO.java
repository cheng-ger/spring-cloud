package com.cyl.it.order.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-25
 */

@Data
public class ResoultVO<T> implements Serializable {


    private static final long serialVersionUID = -7899283150913863466L;

    private Integer code;

    private String msg;

    private T data;


    public ResoultVO() {
    }

    public ResoultVO(Integer code) {
        this.code = code;
    }


    public ResoultVO(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
