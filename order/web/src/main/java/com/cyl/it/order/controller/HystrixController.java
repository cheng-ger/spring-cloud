package com.cyl.it.order.controller;

import com.cyl.it.order.exception.OrderException;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author chengyuanliang
 * @desc  hystrix主要用于服务容错  保证主业务不受影响
 *   1: 降级触发  这个也可在application.yml 中配置
 * @since 2019-05-31
 */
@Slf4j
@RestController
@RequestMapping("hystrixService")
@DefaultProperties(defaultFallback = "defaultFallbackMethod")
public class HystrixController {

    //调用order(本身)服务  异常  降级处理  默认降级处理方法
    @HystrixCommand
    @GetMapping("myDefaultService")
    public String  myDefaultService(){
        log.info("myService的服务降级");
        throw new OrderException("出现异常了====");

        //return "success";
    }

    //调用order(本身)服务  异常  降级处理
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("myService")
    public String  myService(){
        log.info("myService的服务降级");
        throw new OrderException("出现异常了====");

        //return "success";
    }

    //调用product服务  出现异常  降级处理
    @HystrixCommand(fallbackMethod = "fallback")
    @GetMapping("productInfoList")
    public String  getProductInfoList(){
        log.info("如果product服务出现问题，调用product服务的降级");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:60001/productInfoService/findProductInfoByIds";
        String string = restTemplate.postForObject(url, Arrays.asList("1", "2"), String.class);
        return string;
    }


    private  String fallback(){

        return "服务繁忙，请稍后再试~~QAQ";
    }

    private  String defaultFallbackMethod(){

        return "默认提示：服务繁忙，请稍后再试~~QAQ";
    }

    //调用product服务  出现异常  降级处理  超时设置 默认为1000
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",  value = "3000")
    })
    @GetMapping("productInfoListTime")
    public String  getProductInfoListTimeOut(){
        log.info("如果product服务出现问题，调用product服务的降级超时处理");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:60001/productInfoService/findProductInfoByIds";
        String string = restTemplate.postForObject(url, Arrays.asList("2", "3"), String.class);
        return string;
    }


    //调用product服务  出现异常  降级处理  超时设置 默认为1000
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",  value = "true"),//设置熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",  value = "10"),//
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",  value = "1000"),//
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",  value = "60") //在滚动窗口中的
    }, fallbackMethod = "fallback")
    @GetMapping("productInfoListBreaker")
    public String  getProductInfoListCircuitBreaker(@RequestParam Integer number){
        if(number % 2 == 0){
            return "success";
        }
        /*log.info("如果product服务出现问题，调用product服务的降级超时处理");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:60001/productInfoService/findProductInfoByIds";
        String string = restTemplate.postForObject(url, Arrays.asList("2", "3"), String.class);*/
        throw new OrderException("出现异常了====");
    }

    private  String fallback(Integer number){

        return "NUMBER服务繁忙，请稍后再试~~QAQ"+number;
    }

    //在application.yml 中设置
    @HystrixCommand// commandKey 默认为方法名
    @GetMapping("getTimeOut")
    public String  getTimeOut(@RequestParam Integer number){
        if(number % 2 == 0){
            return "success";
        }
        /*log.info("如果product服务出现问题，调用product服务的降级超时处理");
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:60001/productInfoService/findProductInfoByIds";
        String string = restTemplate.postForObject(url, Arrays.asList("2", "3"), String.class);*/
        throw new OrderException("出现异常了====");
    }
}
