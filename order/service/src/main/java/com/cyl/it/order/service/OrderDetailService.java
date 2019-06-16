package com.cyl.it.order.service;

import com.cyl.it.order.co.OrderDetailCO;
import org.springframework.stereotype.Service;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Service
public interface OrderDetailService {

    void addOneOrderDetail(OrderDetailCO detailCO);
}
