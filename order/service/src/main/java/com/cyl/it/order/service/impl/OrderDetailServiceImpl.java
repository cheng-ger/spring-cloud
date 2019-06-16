package com.cyl.it.order.service.impl;

import com.cyl.it.order.co.OrderDetailCO;
import com.cyl.it.order.dao.OrderDetailDao;
import com.cyl.it.order.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    @Transactional
    public void addOneOrderDetail(OrderDetailCO detailCO) {
        orderDetailDao.insertOneOrderDetail(detailCO);
    }
}
