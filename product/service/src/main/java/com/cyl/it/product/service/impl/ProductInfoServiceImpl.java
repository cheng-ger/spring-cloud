package com.cyl.it.product.service.impl;

import com.cyl.it.product.co.CarCO;
import com.cyl.it.product.co.ProductInfoCO;
import com.cyl.it.product.co.ProductInfoCriteriaCO;
import com.cyl.it.product.dao.ProductInfoDao;
import com.cyl.it.product.dto.ProductInfoDto;
import com.cyl.it.product.enums.ProductEnum;
import com.cyl.it.product.exception.ProductException;
import com.cyl.it.product.service.ProductInfoService;
import com.cyl.it.product.util.FastJsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-25
 */
@Service
@Slf4j
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private ProductInfoDao productInfoDao;


    @Override
    @Transactional
    public List<ProductInfoDto> findAllByProductCondition(ProductInfoCriteriaCO criteriaCO) {
        //List<ProductInfoDto> productInfoDtoList = new ArrayList<ProductInfoDto>();
        String productIds =criteriaCO.getProductIds();
        if(null != productIds && "".equals(productIds))  criteriaCO.setProductIdList(Arrays.asList(productIds.split(",")));
        List<ProductInfoDto> productInfoDtoList = productInfoDao.queryAllByProductCondition(criteriaCO);

        return  productInfoDtoList;
    }


    @Transactional
    public List<ProductInfoCO> decreaseStockProcess(List<CarCO> carCOList) {
        List<ProductInfoCO> productInfoCOList = new ArrayList<>();
        for (CarCO carCO : carCOList){
            ProductInfoCriteriaCO productInfoCriteriaCO = new ProductInfoCriteriaCO();
            productInfoCriteriaCO.setProductId(carCO.getProductId());
            List<ProductInfoDto> productInfoDtoList = productInfoDao.queryAllByProductCondition(productInfoCriteriaCO);
            if(null ==productInfoDtoList && productInfoDtoList.isEmpty()){
                throw new ProductException(ProductEnum.NO_EXISTS_PRODUCT.getMsg());
            }
            Integer finalStock = productInfoDtoList.get(0).getProductStock() - carCO.getProductQuantity() ;
            if(finalStock < 0){
                throw new ProductException(ProductEnum.OVER_STOCK.getMsg());
            }
            ProductInfoCO productInfoCO = new ProductInfoCO();
            productInfoCO.setProductId(carCO.getProductId());
            productInfoCO.setProductStock(finalStock);

            productInfoDao.updateProductInfo(productInfoCO);

            productInfoCOList.add(productInfoCO);
        }
        return productInfoCOList;
    }

    @Override
    public void decreaseStock(List<CarCO> carCOList) {

        List<ProductInfoCO> productInfoCOList = decreaseStockProcess(carCOList);

       /* List<ProductInfoDto> productInfoDtoList =  productInfoCOList.stream().map(e -> {
            ProductInfoDto productInfoDto = new ProductInfoDto();
            BeanUtils.copyProperties(e, productInfoDto);
            return productInfoDto;
        }).collect(Collectors.toList());*/
        log.info("库存productStackInfo队列开始发送====>>>stack:{}",productInfoCOList.get(0));
        amqpTemplate.convertAndSend("productStackInfo", FastJsonUtil.objectTOjson(productInfoCOList));

    }
}
