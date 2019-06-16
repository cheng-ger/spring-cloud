package com.cyl.it.product.service.impl;

import com.cyl.it.product.co.ProductCategoryCriteriaCO;
import com.cyl.it.product.co.ProductInfoCriteriaCO;
import com.cyl.it.product.dao.ProductCategoryDao;
import com.cyl.it.product.dao.ProductInfoDao;
import com.cyl.it.product.dto.ProductCategoryDto;
import com.cyl.it.product.dto.ProductInfoDto;
import com.cyl.it.product.service.ProductService;
import com.cyl.it.product.vo.ProductInfoVO;
import com.cyl.it.product.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductCategoryDao productCategoryDao;

    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    @Transactional
    public List<ProductVO> findProduct(ProductCategoryCriteriaCO criteriaCO) {

        List<ProductVO> productVOList = new ArrayList<>();

       List<ProductCategoryDto>  productCategoryDtoList = productCategoryDao.queryAllByProductCategoryCondition(criteriaCO);

       List<ProductInfoDto> productInfoDtoList  =  productInfoDao.queryAllByProductCondition(new ProductInfoCriteriaCO());

        for (int i = 0; i < productCategoryDtoList.size(); i++) {

            ProductVO productVO = new ProductVO();

            ProductCategoryDto pco =  productCategoryDtoList.get(i);

            productVO.setCategoryId(pco.getCategoryId());

            productVO.setCategoryNameCn(pco.getCategoryNameCn());

            productVO.setCategoryNameEn(pco.getCategoryNameEn());

            if(productInfoDtoList.size()> 0){

                List<ProductInfoVO> productInfoVOList = new ArrayList<>();

                for (ProductInfoDto productInfoDto : productInfoDtoList) {

                    if(productInfoDto.getCategoryId().longValue() == pco.getCategoryId().longValue()){

                        ProductInfoVO productInfoVO = new ProductInfoVO();

                        BeanUtils.copyProperties(productInfoDto , productInfoVO);

                        productInfoVOList.add(productInfoVO);
                    }
                }
                productVO.setProductInfoVOList(productInfoVOList);
            }
            productVOList.add(productVO);
        }

        return productVOList;
    }
}
