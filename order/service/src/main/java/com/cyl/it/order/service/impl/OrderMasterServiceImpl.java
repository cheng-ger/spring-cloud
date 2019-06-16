package com.cyl.it.order.service.impl;

import com.cyl.it.order.co.OrderMasterCO;
import com.cyl.it.order.dao.OrderMasterDao;
import com.cyl.it.order.service.OrderMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Service
public class OrderMasterServiceImpl implements OrderMasterService {

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    @Transactional
    public void addOneOrderMaster(OrderMasterCO masterCO) {
        orderMasterDao.insertOneOrderMaster(masterCO);
    }
}
