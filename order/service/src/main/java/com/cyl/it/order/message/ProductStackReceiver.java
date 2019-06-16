package com.cyl.it.order.message;

import com.alibaba.fastjson.JSON;
import com.cyl.it.order.dto.ProductInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@Component
@Slf4j
public class ProductStackReceiver {

    /*@Autowired
    private RedisUtil redisUtil;*/

    private static final String PRODUCT_STOCK_TEMPLATE = "product_stock_%s";/*用productId替代*/

    @Autowired
    private StringRedisTemplate redisTemplate;


    @RabbitListener(queuesToDeclare = @Queue("productStackInfo"))
    public void process(String msg){
        log.info("库存productStackInfo队列接收消息<<====ProductStackReceiver====>>productStockInfo={}",msg);
        List<ProductInfoDto> productInfoDtoList = JSON.parseArray(msg, ProductInfoDto.class);
        for (ProductInfoDto productInfoDto :productInfoDtoList) {
            redisTemplate.opsForValue().set(String.format( PRODUCT_STOCK_TEMPLATE, productInfoDto.getProductId()),
                   String.valueOf( productInfoDto.getProductStock()));


        }
        log.info("redis存储<<===>> key ：product_stock_%s  ===={}" ,productInfoDtoList);
    }
}
