package com.cyl.it.product.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengyuanliang
 * @desc  这个controller 用于个服务之间调用的尝试
 * @since 2019-05-27
 */
@RestController
@Slf4j
@RequestMapping("productServer")
public class ServerController {

    @Value("${env}")
    private String env;

    @GetMapping("m1")
    public  String  m1(){
        return "This is productServer==m1";
    }

    @PostMapping("m2")
    public  String  m2(){
        return "This is productServer==m2";
    }

    @GetMapping("m3")
    public  String  m3(){
        return env;
    }

}
