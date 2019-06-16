package com.cyl.it.order.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Data
public class orderForm {

    @NotEmpty(message ="姓名必填")
    private String name;

    @NotEmpty(message ="手机必填")
    private String phone;

    @NotEmpty(message ="地址必填")
    private String address;

    @NotEmpty(message ="openid必填")
    private String openId;

    @NotEmpty(message ="购物车必填")
    private String item;



}
