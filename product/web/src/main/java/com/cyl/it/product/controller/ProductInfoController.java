package com.cyl.it.product.controller;

import com.cyl.it.product.co.CarCO;
import com.cyl.it.product.co.ProductInfoCriteriaCO;
import com.cyl.it.product.dto.ProductInfoDto;
import com.cyl.it.product.service.ProductInfoService;
import com.cyl.it.product.util.ResultVOUtil;
import com.cyl.it.product.vo.ResoultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */


@Slf4j
@RestController
@RequestMapping("productInfoService")
public class ProductInfoController {

    @Autowired
    private ProductInfoService productInfoService;


    @GetMapping("findProductInfo")
    public ResoultVO  findProductInfoByCondition( ProductInfoCriteriaCO criteriaCO){
        log.info("findProductInfo:{}",criteriaCO );

        List<ProductInfoDto>  productInfoList =  productInfoService.findAllByProductCondition(criteriaCO);

        return ResultVOUtil.success(productInfoList);
    }

    @PostMapping ("findProductInfoByIds")
    public List<ProductInfoDto>  findProductInfoByIds(@RequestBody  List<String> ids){
        log.info("findProductInfoByIds:{}",ids );
        ProductInfoCriteriaCO productInfoCriteriaCO = new ProductInfoCriteriaCO();
        productInfoCriteriaCO.setProductIdList(ids);
        List<ProductInfoDto>  productInfoList =  productInfoService.findAllByProductCondition(productInfoCriteriaCO);

        return productInfoList;
    }


    @PostMapping ("decreaseProductStock")
    public void  decreaseProductStock(@RequestBody List<CarCO> carCOList){

        log.info("decreaseProductStock:{}",carCOList );

        productInfoService.decreaseStock(carCOList);


    }





}
