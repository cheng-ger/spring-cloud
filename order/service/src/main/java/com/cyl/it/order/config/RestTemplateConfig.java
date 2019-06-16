package com.cyl.it.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Component
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        /*RestTemplate restTemplate = new RestTemplate();
        return  restTemplate;*/

        return new RestTemplate();

    }
}
