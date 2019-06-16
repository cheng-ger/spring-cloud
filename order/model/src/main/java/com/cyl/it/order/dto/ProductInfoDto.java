package com.cyl.it.order.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Data
public class ProductInfoDto {

    private  Long productId;

    private String productNameCn;

    private String productNameEn;

    private BigDecimal productPrice;

    private Integer productStock;

    /*private String productDes;*/

    private String productIcon;

    /*private String status;*/

    /*private Long categoryId;*/
}
