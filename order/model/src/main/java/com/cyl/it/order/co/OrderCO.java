package com.cyl.it.order.co;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Data
public class OrderCO {

    private Long orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenId;

    private BigDecimal orderAmount;

    private String orderStatus;

    private String payStatus;

    private List<OrderDetailCO>  orderDetailCOList;
}
