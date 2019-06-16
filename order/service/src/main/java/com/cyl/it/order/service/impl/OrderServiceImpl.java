package com.cyl.it.order.service.impl;

import com.cyl.it.order.client.ProductClient;
import com.cyl.it.order.co.*;
import com.cyl.it.order.dao.OrderDetailDao;
import com.cyl.it.order.dao.OrderMasterDao;
import com.cyl.it.order.dto.OrderDetailDto;
import com.cyl.it.order.dto.OrderMasterDto;
import com.cyl.it.order.dto.ProductInfoDto;
import com.cyl.it.order.enums.OrderEnum;
import com.cyl.it.order.exception.OrderException;
import com.cyl.it.order.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author chengyuanliang
 * @desc
 * @since 2019-05-27
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductClient productClient;

    @Autowired
    private OrderMasterDao orderMasterDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    @Transactional
    public Map<String,Object> addOrder(OrderCO orderCO) {

        /*根据productIds 获取商品信息*/

       List productIdList = orderCO.getOrderDetailCOList().stream()
               .map(OrderDetailCO::getProductId).collect(Collectors.toList());
       List<ProductInfoDto> productInfoDtoList = productClient.findProductInfoByIds(productIdList);


        /*保存订单主体*/
        OrderMasterCO masterCO = new OrderMasterCO();

        Long orderId = orderMasterDao.findNextMasterId();

        BeanUtils.copyProperties(orderCO, masterCO);

        masterCO.setOrderId(orderId);

        masterCO.setOrderStatus(OrderEnum.ORDER_STATUS_UP.getCode());

        masterCO.setPayStatus(OrderEnum.PAY_STATUS_DOWN.getCode());

        /*计算订单总金额*/

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        for(ProductInfoDto productInfoDto : productInfoDtoList){
            for( OrderDetailCO orderDetailCO :orderCO.getOrderDetailCOList()){
                if(orderDetailCO.getProductId().intValue() == productInfoDto.getProductId().intValue()){
                    orderAmount = productInfoDto.getProductPrice()
                                 .multiply(new BigDecimal(orderDetailCO.getProductQuantity()))
                                 .add(orderAmount);
                    BeanUtils.copyProperties(productInfoDto, orderDetailCO);
                    orderDetailCO.setOrderId(orderId);
                    orderDetailCO.setCreateBy("-1");
                    orderDetailCO.setLastUpdateBy("-1");
                    orderDetailDao.insertOneOrderDetail(orderDetailCO);
                    break;
                }


            }
        }
        /*扣库存 */
        List<CarCO> carCOList = orderCO.getOrderDetailCOList().stream()
                .map(e -> new CarCO(e.getProductId(),e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseProductStock(carCOList);

        /*并保存订单详情*/
        masterCO.setOrderAmount(orderAmount);
        masterCO.setCreateBy("-1");
        masterCO.setLastUpdateBy("-1");
        orderMasterDao.insertOneOrderMaster(masterCO);

        Map map = new HashMap();
        map.put("orderId", orderId);

        return map;
    }

    @Override
    @Transactional
    public OrderCO finishOrder(OrderMasterCriteriaCO criteriaCO) {

        List<OrderMasterDto> orderMasterDtoList = orderMasterDao.queryOrderMasterByCondition(criteriaCO);

        if(orderMasterDtoList.isEmpty()){
            throw new OrderException("订单不存在");
        }

        if(OrderEnum.ORDER_STATUS_OVER.getCode().equals(orderMasterDtoList.get(0).getOrderStatus())){
            throw new OrderException("订单已完成");
        }

        OrderMasterCO orderMasterCO = new OrderMasterCO();
        orderMasterCO.setOrderId(criteriaCO.getOrderId());
        orderMasterCO.setOrderStatus(OrderEnum.ORDER_STATUS_OVER.getCode());
        orderMasterDao.updateOneOrderMaster(orderMasterCO);

        OrderCO orderCO = new OrderCO();
        BeanUtils.copyProperties(orderMasterDtoList.get(0), orderCO);
        OrderDetailCriteriaCO orderDetailCriteriaCO = new OrderDetailCriteriaCO();
        orderDetailCriteriaCO.setOrderId(criteriaCO.getOrderId());
        List<OrderDetailDto> OrderDetailDtoList = orderDetailDao.queryOrderDetailByCondition(orderDetailCriteriaCO);

        List<OrderDetailCO> orderDetailCOList = OrderDetailDtoList.stream().map(e -> {
            OrderDetailCO orderDetailCO = new OrderDetailCO();
            BeanUtils.copyProperties(e, orderDetailCO);
            return orderDetailCO;
        }).collect(Collectors.toList());
        orderCO.setOrderStatus(OrderEnum.ORDER_STATUS_OVER.getCode());
        orderCO.setOrderDetailCOList(orderDetailCOList);

        return orderCO;
    }
}
