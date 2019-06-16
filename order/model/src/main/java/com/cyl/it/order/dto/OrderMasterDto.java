package com.cyl.it.order.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Data
public class OrderMasterDto extends BaseDto {

   /* `order_id`  BIGINT  PRIMARY KEY AUTO_INCREMENT          ,
    `buyer_name`  VARCHAR(128) NOT NULL COMMENT '买家名字'  ,
    `buyer_phone`  VARCHAR(32) NOT NULL COMMENT '电话'      ,
    `buyer_address`	 VARCHAR(256) NOT NULL COMMENT '电话'	,
    `buyer_open_id`	 VARCHAR(64) NOT NULL COMMENT '微信openid'	,
    `order_amount`	 DECIMAL(8,2) NOT NULL COMMENT '订单总金额'	,
    `order_status`	 CHAR(1) NOT NULL DEFAULT '1' COMMENT '订单状态'	,
    `pay_status`	 CHAR(1) NOT NULL DEFAULT '0' COMMENT '支付状态 0:未支付' ,
  */


    private Long orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenId;

    private BigDecimal orderAmount;

    private String orderStatus;

    private String payStatus;


}
