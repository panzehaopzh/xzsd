package com.xzsd.app.clientOrder.dao;

import com.xzsd.app.clientOrder.entity.*;
import com.xzsd.app.managerOrder.entity.OrderStateInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ClientOrderDao
 * @Description clientOrder
 * @author panzehao
 * @date 2020-04-26
 */
@Mapper
public interface ClientOrderDao {
    /**
     * 查询商品库存
     * @param listGoodsCode
     * @return
     */
    List<GoodsInfo> getGoodsStock(@Param("listGoodsCode") List<String> listGoodsCode);

    /**
     * 新增订单
     * @param orderInfo
     * @reurn
     */
    int addOrder(OrderInfo orderInfo);

    /**
     * 新增订单到订单详情表
     * @param orderInfoList
     * @return
     */
    int addOrderDetail(@Param("orderInfoList") List<OrderInfo>  orderInfoList);

    /**
     * 修改商品库存
     * @param listGoodsStock
     * @return
     */
    int updateGoodsStock(@Param("listGoodsStock") List<GoodsInfo> listGoodsStock);

    /**
     * 删除购物车
     * @param listShopCartId
     * @param userId
     * @return
     */
    int deleteShopCart(@Param("listShopCartId") List<String> listShopCartId,@Param("userId") String userId);

    /**
     * 查询订单列表
     * @param orderVo
     * @return
     */
    List<ClientOrderInfo> listOrder(OrderVo orderVo);

    /**
     * 修改订单状态
     * @param orderStateInfo
     * @return
     */
    int updateOrderState(OrderStateInfo orderStateInfo);

    /**
     * 取消订单时库存回滚
     * @param listGoodsCount
     * @param userId
     * @return
     */
    int rollBackStock(@Param("listGoodsCount") List<EvaluateStarInfo> listGoodsCount,@Param("userId")String userId);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    ClientOrderDetailInfo listOrderDeepen(@Param("orderId") String orderId);

    /**
     * 查询订单评价商品信息列表
     * @param orderId
     * @return
     */
    List<EvaluateGoodsInfo> listGoodsForEvaluate(@Param("orderId") String orderId);

    /**
     * 新增订单商品评价
     * @param evaluateList
     * @return
     */
    int addGoodsEvaluate(@Param("evaluateList") List<GoodsEvaluateInfo> evaluateList);

    /**
     * 查询商品评价星级
     * @param listGoodsCode
     * @return
     */
    List<EvaluateStarInfo> listEvaluateStar(@Param("listGoodsCode") List<String> listGoodsCode);

    /**
     * 查询订单商品购买数量
     * @param orderId
     * @return
     */
    List<EvaluateStarInfo> listGoodsCount(@Param("orderId") String orderId);

    /**
     * 更新商品库存
     * @param listGoodsCount
     * @param userId
     * @return
     */
    int updateSalesVolume(@Param("listGoodsCount") List<EvaluateStarInfo> listGoodsCount,@Param("userId") String userId);

    /**
     * 更新商品星级
     * @param listGoodsStar
     * @return
     */
    int updateGoodsStar(@Param("listGoodsStar") List<EvaluateStarInfo> listGoodsStar);

    /**
     * 修改订单状态为已完成已评价
     * @param orderId
     * @param userId
     * @return
     */
    int updateOrderStates(@Param("orderId") String orderId,@Param("userId") String userId);
}
