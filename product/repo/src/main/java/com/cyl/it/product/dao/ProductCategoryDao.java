package com.cyl.it.product.dao;

import com.cyl.it.product.co.ProductCategoryCriteriaCO;
import com.cyl.it.product.dto.ProductCategoryDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc 商品信息
 * @since 2019-05-25
 */
@Repository
public interface ProductCategoryDao {

    List<ProductCategoryDto> queryAllByProductCategoryCondition(ProductCategoryCriteriaCO criteriaCO);
}
