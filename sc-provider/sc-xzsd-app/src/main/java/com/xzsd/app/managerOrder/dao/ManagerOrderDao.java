package com.xzsd.app.managerOrder.dao;

import com.xzsd.app.managerOrder.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ManagerOrderDao
 * @Description managerOrder
 * @author panzehao
 * @date 2020-04-25
 */
@Mapper
public interface ManagerOrderDao {
    /**
     * 查询店长订单列表
     * @param managerOrderVo
     * @return
     */
    List<ManagerOrderInfo> listManagerOrders(ManagerOrderVo managerOrderVo);

    /**
     * 修改店长订单状态
     * @param orderStateInfo
     * @return
     */
    int updateManagerOrderState(OrderStateInfo orderStateInfo);

    /**
     * 查询店长订单详情
     * @param orderId
     * @return
     */
    OrderDetailInfo listManagerOrderDeepen(@Param("orderId") String orderId);

}
