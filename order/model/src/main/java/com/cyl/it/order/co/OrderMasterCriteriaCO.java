package com.cyl.it.order.co;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-31
 */
@Data
public class OrderMasterCriteriaCO {
    private Long orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenId;

    private BigDecimal orderAmount;

    private String orderStatus;

    private String payStatus;
}
