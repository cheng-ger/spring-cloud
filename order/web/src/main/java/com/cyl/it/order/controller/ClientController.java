package com.cyl.it.order.controller;

import com.cyl.it.order.client.ProductClient;
import com.cyl.it.order.dto.ProductInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;

/**
 * @author chengyuanliang
 * @desc  这个主要用于 模块之间的调用的  验证controller
 *        这里用（restTemplate【三种方式】 与  feign ）的调用
 * @since 2019-05-27
 */
@RestController
@Slf4j
@RequestMapping("client")
public class ClientController {


    /*@Autowired
    private OrderMasterDao orderMasterDao;*/
    /*使用feign 进行模块调用*/
    @Autowired
    private ProductClient productClient;

    /*方法三  在config中 作为bean*/
    @Autowired
    private RestTemplate restTemplatec;

    /*方法二用*/
    @Autowired
    private LoadBalancerClient balancerClient;

    @GetMapping("restTemplateA")
    public  String  restTemplateA(){
        //RestTemplate  方法一  死地址 不推荐使用  只做了解
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:60001/productServer/m1";
        String response= restTemplate.getForObject(url, String.class);
        log.info("response={}" , response);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
                                    null, String.class, new HashMap<>());
        log.info("responseEntity={} <<==>>{}" ,responseEntity, responseEntity.getBody() );

        return response;
    }


    @GetMapping("restTemplateB")
    public  String  restTemplateB(){
        //RestTemplate  方法二  相当于方法三的详细过程
        RestTemplate restTemplate = new RestTemplate();

        ServiceInstance productService = balancerClient.choose("PRODUCT");

        String url = String.format("http://%s:%s/%s/%s", productService.getHost(),
                                    productService.getPort(), "productServer", "m1");

        String response= restTemplate.getForObject(url, String.class);

        log.info("productService={}" , productService);
        return response;
    }


    @GetMapping("restTemplateC")
    public  String  restTemplateC(){
        //RestTemplate  方法三   方法二的详细过程  注意这里需要URL中要加上应用名
        // String url = "http://localhost:60001/productServer/m1";
        String appName = "product";
        String url = String.format("http://%s/productServer/m1", appName);
        String response = restTemplatec.getForObject(url, String.class);

        log.info("http://{}/productServer/m1",appName);
        return response;
    }


    @GetMapping("feignA")
    public  String  feignA(){
        //RestTemplate  方法三   方法二的详细过程  注意这里需要URL中要加上应用名
        // String url = "http://localhost:60001/productServer/m1";
        log.info("<<====================feignA=============================>>");
        return productClient.m1();
    }


    @PostMapping("getProductInfoList")
    public  List<ProductInfoDto>  getProductInfoList(@RequestBody List<String> ids){
        //feign

        log.info("<<====================getProductInfoList=============================>>");
        return productClient.findProductInfoByIds(ids);
    }

    /*@GetMapping("max")
    public  Long  getMax(){
        //feign

        log.info("<<====================getMax=============================>>");
        return orderMasterDao.findNextMasterId();
    }*/

}
