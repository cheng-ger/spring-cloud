package com.cyl.it.order.dao;

import com.cyl.it.order.co.OrderMasterCO;
import com.cyl.it.order.co.OrderMasterCriteriaCO;
import com.cyl.it.order.dto.OrderMasterDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */

@Repository
public interface OrderMasterDao {

    void insertOneOrderMaster(OrderMasterCO masterCO);

    Long findNextMasterId();

    List<OrderMasterDto> queryOrderMasterByCondition(OrderMasterCriteriaCO criteriaCO);

    void updateOneOrderMaster(OrderMasterCO masterCO);


}
