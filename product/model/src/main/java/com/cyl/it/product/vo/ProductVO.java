package com.cyl.it.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
@Data
public class ProductVO {


    @JsonProperty("id")
    private Long categoryId;

    @JsonProperty("nameCn")
    private String categoryNameCn;

    @JsonProperty("nameEn")
    private String categoryNameEn;

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;

}
