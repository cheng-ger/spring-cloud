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
public class OrderDetailCO extends BaseDto {

    private Long detailId;

    private Long orderId;

    private Long productId;

    private String productNameCn;

    private String productNameEn;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;

}
