package com.cyl.it.product.controller;

import com.cyl.it.product.co.ProductCategoryCriteriaCO;
import com.cyl.it.product.service.ProductService;
import com.cyl.it.product.util.ResultVOUtil;
import com.cyl.it.product.vo.ResoultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-25
 */
@RestController
@Slf4j
@RequestMapping(value = "productService")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("findAllCategory")
    public ResoultVO  findAllProductCategory(){
        log.info("进入findAllCategory：{}" , new Date());

        return ResultVOUtil.success(productService.findProduct(new ProductCategoryCriteriaCO()));
    }
}
