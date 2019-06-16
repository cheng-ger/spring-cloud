package com.cyl.it.product.service;

import com.cyl.it.product.co.ProductCategoryCriteriaCO;
import com.cyl.it.product.vo.ProductVO;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
public interface ProductService {


    List<ProductVO> findProduct(ProductCategoryCriteriaCO criteriaCO);
}
