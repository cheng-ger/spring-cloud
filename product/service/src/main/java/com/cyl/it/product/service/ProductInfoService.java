package com.cyl.it.product.service;

import com.cyl.it.product.co.CarCO;
import com.cyl.it.product.co.ProductInfoCriteriaCO;
import com.cyl.it.product.dto.ProductInfoDto;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-25
 */

public interface ProductInfoService {

    List<ProductInfoDto> findAllByProductCondition(ProductInfoCriteriaCO criteriaCO);


    void decreaseStock(List<CarCO> carCOList);
}
