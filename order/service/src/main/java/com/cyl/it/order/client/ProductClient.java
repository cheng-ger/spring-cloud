package com.cyl.it.order.client;


import com.cyl.it.order.co.CarCO;
import com.cyl.it.order.dto.ProductInfoDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/productServer/m1")
    public  String m1();


    @PostMapping("productInfoService/findProductInfoByIds")
    public List<ProductInfoDto> findProductInfoByIds(@RequestBody List<String> ids);


    @PostMapping("productInfoService/decreaseProductStock")
    public void decreaseProductStock(@RequestBody List<CarCO> carCOList);


}
