package com.cyl.it.order.controller;

import com.cyl.it.order.co.OrderCO;
import com.cyl.it.order.co.OrderMasterCriteriaCO;
import com.cyl.it.order.converter.OrderForm2OrderCO;
import com.cyl.it.order.enums.ResoultEnum;
import com.cyl.it.order.exception.OrderException;
import com.cyl.it.order.form.orderForm;
import com.cyl.it.order.service.OrderService;
import com.cyl.it.order.util.ResultVOUtil;
import com.cyl.it.order.vo.ResoultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-26
 */
@Slf4j
@RestController
@RequestMapping("orderService")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("hi")
    public  String  holleWord(){
        return "hello word";
    }

    @PostMapping("createOrder")
    public ResoultVO addOrder(@Valid orderForm orderForm , BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数错误，orderForm={}",orderForm);
            throw new OrderException(ResoultEnum.PARAM_ERROR.getCode() ,
                     bindingResult.getFieldError().getDefaultMessage()  );
        }

        OrderCO  orderCO =OrderForm2OrderCO.convert(orderForm);

        Map m = orderService.addOrder(orderCO);

        return ResultVOUtil.success(m);
    }



    @GetMapping ("finishOrder")
    public ResoultVO addOrder(@RequestParam Long orderId){


        OrderMasterCriteriaCO criteriaCO = new OrderMasterCriteriaCO();
        criteriaCO.setOrderId(orderId);
        return ResultVOUtil.success(orderService.finishOrder(criteriaCO));
    }

}
