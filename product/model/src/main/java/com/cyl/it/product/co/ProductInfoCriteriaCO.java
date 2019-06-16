package com.cyl.it.product.co;

import lombok.Data;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
@Data
public class ProductInfoCriteriaCO  {

    private  Long productId;

    private String productNameCn;

    private String productNameEn;

    private String status;

    private Long categoryId;

    private String productIds;

    private List<String> productIdList;

}
