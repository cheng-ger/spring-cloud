package com.cyl.it.order.service;

import com.cyl.it.order.co.OrderMasterCO;
import org.springframework.stereotype.Service;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Service
public interface OrderMasterService {

    void addOneOrderMaster(OrderMasterCO masterCO);
}
