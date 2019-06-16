package com.cyl.it.order.enums;

import lombok.Getter;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-28
 */
@Getter
public enum OrderEnum {

    ORDER_STATUS_UP("1" , "已下单"),
    ORDER_STATUS_DOWN("0" , "已撤单"),
    ORDER_STATUS_OVER("2" , "已完成"),

    PAY_STATUS_UP("1","已支付"),
    PAY_STATUS_DOWN("0","未支付"),
    //PAY_STATUS_OVER("2",""),

    ;
    private String code;

    private String msg;

    OrderEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }}
