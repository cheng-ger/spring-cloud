package com.cyl.it.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
@Data
public class ProductInfoVO {

    @JsonProperty("id")
    private  Long productId;

    @JsonProperty("nameCn")
    private String productNameCn;

    @JsonProperty("nameEn")
    private String productNameEn;

    @JsonProperty("price")
    private Double productPrice;

   /* private Integer productStock;*/

    @JsonProperty("desc")
    private String productDes;

    @JsonProperty("icon")
    private String productIcon;

   /* private String status;

    private Long categoryId;*/




}
