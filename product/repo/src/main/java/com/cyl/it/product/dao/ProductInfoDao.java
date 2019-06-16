package com.cyl.it.product.dao;


import com.cyl.it.product.co.ProductInfoCO;
import com.cyl.it.product.co.ProductInfoCriteriaCO;
import com.cyl.it.product.dto.ProductInfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc 商品信息
 * @since 2019-05-25
 */
@Repository
public interface ProductInfoDao {


    // void   insertBatchProduct(List<ProductInfoCO> coList);


    /**
     * @param criteriaCO
     * @return
     * 根据条件查询
     */
    List<ProductInfoDto> queryAllByProductCondition(ProductInfoCriteriaCO criteriaCO);


    void updateProductInfo(ProductInfoCO productInfoCO);


}
