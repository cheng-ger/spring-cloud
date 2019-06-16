package com.cyl.it.gateway.filter;

import com.cyl.it.gateway.util.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author chengyuanliang
 * @desc 鉴权  权限校验 区分买家卖家
 * @since 2019-05-30
 */
@Component
@Slf4j
public class AuthFilter extends ZuulFilter {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //  /orderService/createOrder 买家  (cookie中有openId)
        //  /orderService/finishOrder 卖家  （cookie中有token  ，并redis中有对应值）
        // /productService/findAllCategory 都可访问
        log.info("request===URL:{}" ,request.getRequestURI() );
        if("/order/orderService/createOrder".equals(request.getRequestURI())){

            Cookie cookie = CookieUtil.get(request, "openId");
            if(null == cookie || StringUtils.isEmpty(cookie.getValue())){
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                requestContext.setSendZuulResponse(false);
            }
        }
        if("/order/orderService/finishOrder".equals(request.getRequestURI())){
            String keyTemplate = "token_%s";
            Cookie cookie = CookieUtil.get(request, "token");
            log.info("<<<<<=====cookie====>>>token:{}",cookie.getValue() );
            if(null == cookie || StringUtils.isEmpty(cookie.getValue())
               || StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(keyTemplate, cookie.getValue())))) {
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                requestContext.setSendZuulResponse(false);
            }
        }
        return null;
    }
}
