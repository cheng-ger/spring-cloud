package com.cyl.it.order.dao;

import com.cyl.it.order.co.OrderDetailCO;
import com.cyl.it.order.co.OrderDetailCriteriaCO;
import com.cyl.it.order.dto.OrderDetailDto;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Repository
public interface OrderDetailDao {

    void insertOneOrderDetail(OrderDetailCO detailCO);

    List<OrderDetailDto> queryOrderDetailByCondition(OrderDetailCriteriaCO criteriaCO);

}
