package com.cyl.it.order.service;


import com.cyl.it.order.co.OrderCO;
import com.cyl.it.order.co.OrderMasterCriteriaCO;
import com.cyl.it.order.dto.OrderMasterDto;

import java.util.Map;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */

public interface OrderService {

    Map<String,Object> addOrder(OrderCO orderCO);

    OrderCO  finishOrder(OrderMasterCriteriaCO criteriaCO) ;
}
