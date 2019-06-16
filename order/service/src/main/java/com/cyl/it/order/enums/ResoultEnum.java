package com.cyl.it.order.enums;

import lombok.Getter;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Getter
public enum ResoultEnum {

    PARAM_ERROR(1,"参数错误"),
    ;
    private Integer code;

    private String msg;

    ResoultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }}
