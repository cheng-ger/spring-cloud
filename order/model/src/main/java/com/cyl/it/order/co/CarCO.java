package com.cyl.it.order.co;

import lombok.Data;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-28
 */
@Data
public class CarCO {

    private Long productId;

    private Integer productQuantity;

    public CarCO() {
    }

    public CarCO(Long productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
