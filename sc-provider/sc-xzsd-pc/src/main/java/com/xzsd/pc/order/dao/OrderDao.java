package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetailInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName OrderDao
 * @Description order
 * @author panzehao
 * @date 2020-04-13
 */
@Mapper
public interface OrderDao {
    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    List<OrderDetailInfo> getListOrder(@Param("orderCode") String orderCode);

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    List<OrderVo> listOrderByPage(OrderInfo orderInfo);

    /**
     * 修改订单状态
     * @param listcode 订单编号集合
     * @param orderState 订单状态
     * @param userId 更新人
     * @return
     */
    int updateOrderState(@Param("listCode") List<String> listcode,@Param("orderState") String orderState,@Param("userId") String userId);
}
