package com.cyl.it.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
//@SpringCloudApplication 可用这个注解代替这三个注解  @SpringBootApplication @EnableDiscoveryClient @EnableCircuitBreaker
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@MapperScan(basePackages = "com.cyl.it.order.dao")
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
