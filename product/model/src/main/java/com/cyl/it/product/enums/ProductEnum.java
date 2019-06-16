package com.cyl.it.product.enums;

import lombok.Getter;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
@Getter
public enum ProductEnum {

    STATUS_UP("1","上架"),

    STATUS_DOWN("0","下架"),

    NO_EXISTS_PRODUCT("3","商品不存在"),

    OVER_STOCK("4", "库存不足"),
    ;

    private  String code ;

    private String msg;



    ProductEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }}
