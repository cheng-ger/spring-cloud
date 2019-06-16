package com.cyl.it.order.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Data
public class OrderDetailDto extends  BaseDto {

    /*`detail_id` BIGINT PRIMARY KEY AUTO_INCREMENT,
    `order_id` BIGINT NOT NULL COMMENT '订单ID',
    `product_id` BIGINT NOT NULL COMMENT '商品ID',
    `product_name_cn` VARCHAR (256) NOT NULL COMMENT '',
    `product_name_en` VARCHAR (64) NOT NULL COMMENT '微信openid',
    `product_price` DECIMAL (8, 2) NOT NULL COMMENT '订单总金额',
    `product_quantity` CHAR(1) NOT NULL DEFAULT '1' COMMENT '订单状态',
    `product_icon` CHAR(1) NOT NULL DEFAULT '0' COMMENT '支付状态 0:未支付',*/

    private Long detailId;

    private Long orderId;

    private Long productId;

    private String productNameCn;

    private String productNameEn;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;




}
