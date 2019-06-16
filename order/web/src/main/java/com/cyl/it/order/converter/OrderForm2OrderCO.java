package com.cyl.it.order.converter;

import com.cyl.it.order.co.OrderCO;
import com.cyl.it.order.co.OrderDetailCO;
import com.cyl.it.order.form.orderForm;
import com.cyl.it.order.util.FastJsonUtil;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-28
 */
public class OrderForm2OrderCO {

    public static OrderCO convert(orderForm orderForm){

        OrderCO orderCO = new OrderCO();

        orderCO.setBuyerName(orderForm.getName());
        orderCO.setBuyerPhone(orderForm.getPhone());
        orderCO.setBuyerAddress(orderForm.getAddress());
        orderCO.setBuyerOpenId(orderForm.getOpenId());

        List<OrderDetailCO> orderDetailCOList =FastJsonUtil.jsonToList(orderForm.getItem() , OrderDetailCO.class);
        orderCO.setOrderDetailCOList(orderDetailCOList);

        return orderCO;
    }
}
