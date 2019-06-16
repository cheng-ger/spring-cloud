package com.cyl.it.product.service;

import com.cyl.it.product.co.ProductCategoryCriteriaCO;
import com.cyl.it.product.dto.ProductCategoryDto;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-25
 */

public interface ProductCategoryService {

    List<ProductCategoryDto> findAllByProductCategoryCondition(ProductCategoryCriteriaCO criteriaCO);
}
