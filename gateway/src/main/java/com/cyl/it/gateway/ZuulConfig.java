package com.cyl.it.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-30
 */
@Component
public class ZuulConfig {

    /*也可以放在启动类中*/
    @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
