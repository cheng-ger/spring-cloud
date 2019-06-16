package com.cyl.it.product.service.impl;

import com.cyl.it.product.co.ProductCategoryCriteriaCO;
import com.cyl.it.product.dao.ProductCategoryDao;
import com.cyl.it.product.dto.ProductCategoryDto;
import com.cyl.it.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-25
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Override
    @Transactional
    public List<ProductCategoryDto> findAllByProductCategoryCondition(ProductCategoryCriteriaCO criteriaCO) {

        return productCategoryDao.queryAllByProductCategoryCondition(criteriaCO);
    }
}
