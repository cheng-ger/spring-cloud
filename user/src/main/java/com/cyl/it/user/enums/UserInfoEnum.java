package com.cyl.it.user.enums;

import lombok.Getter;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@Getter
public enum UserInfoEnum {

    BUYER("1","买家"),
    SELLER("2","卖家"),
    LOGIN_FAIL("1","登录失败"),
    LOGIN_SUC("0","登录成功"),
    LOGIN_IN("0","已登录"),
    ROLE_ERROR("0","角色有误"),
//    ("",""),
//    BUYER("",""),
//    BUYER("",""),
    ;

    private String code;

    private String msg;

    UserInfoEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }}
