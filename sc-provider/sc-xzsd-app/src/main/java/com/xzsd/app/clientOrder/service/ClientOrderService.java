package com.xzsd.app.clientOrder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientOrder.dao.ClientOrderDao;
import com.xzsd.app.clientOrder.entity.*;
import com.xzsd.app.managerOrder.entity.OrderStateInfo;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ClientOrderService
 * @Description 用户订单
 * @author panzehao
 * @date 2020-04-2
 */
@Service
public class ClientOrderService {

    @Resource
    private ClientOrderDao clientOrderDao;

    /**
     * clientOrder 新增订单
     * @param orderInfo
     * @return
     * @author panzehao
     * @date 2020-04-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(OrderInfo orderInfo){
        //分割商品编号
        List<String> listGoodsCode = Arrays.asList(orderInfo.getGoodsCode().split(","));
        //分割商品价格
        List<String> listGoodsPrice = Arrays.asList(orderInfo.getGoodsPrice().split(","));
        //分割商品数量
        List<String> listClientGoodsNum = Arrays.asList(orderInfo.getClientGoodsNum().split(","));
        //分割购物车编号
        List<String> listShopCartId = Arrays.asList(orderInfo.getShopCartId().split(","));
        //查询商品库存
        List<GoodsInfo> listGoodsStock = clientOrderDao.getGoodsStock(listGoodsCode);
        List<OrderInfo> orderInfoList = new ArrayList<OrderInfo>();
        //设置订单总价
        double goodsOrderCount = 0.0f;
        //生成订单编号
        String orderId = StringUtil.getCommonCode(2);
        //判断商品数量是否超过库存
        for(int i = 0; i < listGoodsStock.size();i++) {
            for(int j = 0; j < listGoodsStock.size();j++) {
                if(listGoodsCode.get(i).equals(listGoodsStock.get(j).getGoodsCode())) {
                    if (Integer.valueOf(listClientGoodsNum.get(i)) > listGoodsStock.get(j).getGoodsStock()) {
                        return AppResponse.bizError("当前购买的商品编号为" + listGoodsStock.get(j).getGoodsCode() + "的商品数量已超过库存，请重新选择商品数量！");
                    }
                    //更新商品库存
                    listGoodsStock.get(j).setGoodsStock(listGoodsStock.get(j).getGoodsStock()-Integer.valueOf(listClientGoodsNum.get(i)));
                }
            }
        }
        //遍历商品
        for(int i = 0;i < listGoodsStock.size();i++){
            listGoodsStock.get(i).setUpdateId(orderInfo.getCreateId());
            //计算订单总价
            goodsOrderCount += new BigDecimal(listGoodsPrice.get(i)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()*Integer.valueOf(listClientGoodsNum.get(i));
            //计算单个商品总价
            double totalNum = new BigDecimal(listGoodsPrice.get(i)).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue()*Integer.valueOf(listClientGoodsNum.get(i));
            //生成订单详情编码
            String orderDetailCode = StringUtil.getCommonCode(4);
            OrderInfo orderdetailInfo = new OrderInfo();
            orderdetailInfo.setOrderId(orderId);
            orderdetailInfo.setOrderDetailCode(orderDetailCode);
            orderdetailInfo.setGoodsCode(listGoodsCode.get(i));
            orderdetailInfo.setGoodsPrice(listGoodsPrice.get(i));
            orderdetailInfo.setClientGoodsNum(listClientGoodsNum.get(i));
            orderdetailInfo.setTotalNum(String.valueOf(totalNum));
            orderdetailInfo.setCreateId(orderInfo.getCreateId());
            orderInfoList.add(orderdetailInfo);
        }
        orderInfo.setOrderId(orderId);
        //将计算出的订单总价放入实体类
        orderInfo.setOrderAllCost(String.valueOf(goodsOrderCount));
        //将订单商品数量放入实体类
        orderInfo.setOrderAllGoodsCount(listGoodsCode.size());
        //删除购物车
        if(!"0".equals(orderInfo.getShopCartId())){
            int deleteShopCart = clientOrderDao.deleteShopCart(listShopCartId,orderInfo.getCreateId());
            if(0 == deleteShopCart){
                return AppResponse.versionError("删除购物车失败，请重试！");
            }
        }
        //新增订单
        int addOrder = clientOrderDao.addOrder(orderInfo);
        //新增订单到订单详情表
        int addOrderDetail = clientOrderDao.addOrderDetail(orderInfoList);
        //更新商品库存
        int updateGoodsStock = clientOrderDao.updateGoodsStock(listGoodsStock);
        if(0 == addOrder || 0 == addOrderDetail || 0 == updateGoodsStock){
            return AppResponse.versionError("新增订单失败，请重试！");
        }
        return AppResponse.success("新增订单成功！");
    }

    /**
     * clientOrder 查询订单列表
     * @param orderVo
     * @return
     * @author panzehao
     * @date 2020-04-26
     */
    public AppResponse listOrder(OrderVo orderVo){
        PageHelper.startPage(orderVo.getPageNum(),orderVo.getPageSize());
        List<ClientOrderInfo> clientOrderInfoList = clientOrderDao.listOrder(orderVo);
        //包装Page对象
        PageInfo<ClientOrderInfo> pageData = new PageInfo<ClientOrderInfo>(clientOrderInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * clientOrder 修改订单状态
     * @param orderStateInfo
     * @return
     * @author panzehao
     * @date 2020-04-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderStateInfo orderStateInfo){
        int count = clientOrderDao.updateOrderState(orderStateInfo);
        //取消订单，库存回滚
        if ("5".equals(orderStateInfo.getOrderStateId())){
            //查询订单商品购买数量
            List<EvaluateStarInfo> listGoodsCount = clientOrderDao.listGoodsCount(orderStateInfo.getOrderId());
            //库存回滚
            int rollBackStock = clientOrderDao.rollBackStock(listGoodsCount,orderStateInfo.getUserId());
            if(0 == rollBackStock){
                return AppResponse.bizError("库存回滚失败，请重试！");
            }
        }
        if(0 == count){
            return AppResponse.versionError("修改订单状态失败，请重试！");
        }
        return AppResponse.success("修改订单状态成功！");
    }

    /**
     * clientOrder 查询订单详情
     * @param orderId
     * @return
     * @author panzehao
     * @date 2020-04-26
     */
    public AppResponse listOrderDeepen(String orderId){
        ClientOrderDetailInfo clientOrderDetailInfo = clientOrderDao.listOrderDeepen(orderId);
        return AppResponse.success("查询订单详情成功！",clientOrderDetailInfo);
    }

    /**
     * clientOrder 查询订单评价商品信息列表
     * @param orderId
     * @return
     * @author panzehao
     * @date 2020-04-26
     */
    public AppResponse listGoodsForEvaluate(String orderId){
        List<EvaluateGoodsInfo> evaluateGoodsInfoList = clientOrderDao.listGoodsForEvaluate(orderId);
        return AppResponse.success("查询成功！",evaluateGoodsInfoList);
    }

    /**
     * clientOrder 新增订单商品评价
     * @param evaluateOrder
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsEvaluate(EvaluateInfo evaluateOrder,String userId){
        //商品编号集合
        List<String> listGoodsCode = new ArrayList<>();
         //遍历商品评价信息集合
        for(int i = 0; i < evaluateOrder.getEvaluateList().size(); i++){
            evaluateOrder.getEvaluateList().get(i).setEvaluateCode(StringUtil.getCommonCode(2));
            evaluateOrder.getEvaluateList().get(i).setUserId(userId);
            evaluateOrder.getEvaluateList().get(i).setOrderId(evaluateOrder.getOrderId());
            listGoodsCode.add(evaluateOrder.getEvaluateList().get(i).getGoodsCode());
        }
        //新增评价
        int addGoodsEvaluate = clientOrderDao.addGoodsEvaluate(evaluateOrder.getEvaluateList());
        //查询商品星级
        List<EvaluateStarInfo> listGoodsStar = clientOrderDao.listEvaluateStar(listGoodsCode);
        //查询订单商品购买数量
        List<EvaluateStarInfo> listGoodsCount = clientOrderDao.listGoodsCount(evaluateOrder.getOrderId());
        //将商品星级保留一位小数
        for(int i = 0; i < listGoodsStar.size() ; i++){
            double avgStar = 0.0f;
            if(listGoodsStar.get(i).getEvaluateStar() != null) {
                avgStar = new BigDecimal(listGoodsStar.get(i).getEvaluateStar()).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
            }
            listGoodsStar.get(i).setEvaluateStar(String.valueOf(avgStar));
            listGoodsStar.get(i).setUserId(userId);
        }
        //更新商品销量
        int updateSalesVolume = clientOrderDao.updateSalesVolume(listGoodsCount,userId);
        //更新商品星级
        int updateGoodsStar = clientOrderDao.updateGoodsStar(listGoodsStar);
        //更新订单状态为已完成已评价
        int updateOrderStates = clientOrderDao.updateOrderStates(evaluateOrder.getOrderId(),userId);
        if(0 == addGoodsEvaluate || 0 == updateGoodsStar || 0 == updateOrderStates || 0 == updateSalesVolume){
            return AppResponse.versionError("评价失败，请重试！");
        }
        return AppResponse.success("评价成功！");
    }
}
