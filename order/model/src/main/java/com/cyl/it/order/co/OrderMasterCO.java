package com.cyl.it.order.co;

import com.cyl.it.order.dto.BaseDto;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Data
public class OrderMasterCO  extends BaseDto {

    private Long orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenId;

    private BigDecimal orderAmount;

    private String orderStatus;

    private String payStatus;
}
