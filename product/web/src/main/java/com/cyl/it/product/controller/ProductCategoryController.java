package com.cyl.it.product.controller;

import com.cyl.it.product.co.ProductCategoryCriteriaCO;
import com.cyl.it.product.dto.ProductCategoryDto;
import com.cyl.it.product.service.ProductCategoryService;
import com.cyl.it.product.vo.ResoultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cyl.it.product.util.ResultVOUtil;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */


@Slf4j
@RestController
@RequestMapping("productCategoryService")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;


    @GetMapping("findProductCategory")
    public ResoultVO  findAllProductCategory( ProductCategoryCriteriaCO criteriaCO){
        List<ProductCategoryDto> productCategoryDtoList = productCategoryService.findAllByProductCategoryCondition(criteriaCO);

        return ResultVOUtil.success(productCategoryDtoList);
    }



}
