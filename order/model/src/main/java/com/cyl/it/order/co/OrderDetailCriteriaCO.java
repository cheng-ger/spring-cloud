package com.cyl.it.order.co;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-31
 */
@Data
public class OrderDetailCriteriaCO {
    private Long detailId;

    private Long orderId;

    private Long productId;

    private String productNameCn;

    private String productNameEn;

    private BigDecimal productPrice;
}
