package com.xzsd.app.clientOrder.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientOrder.entity.EvaluateInfo;
import com.xzsd.app.clientOrder.entity.OrderInfo;
import com.xzsd.app.clientOrder.entity.OrderVo;
import com.xzsd.app.clientOrder.service.ClientOrderService;
import com.xzsd.app.managerOrder.entity.OrderStateInfo;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ClientOrderController
 * @Description 用户订单
 * @author panzehao
 * @date 2020-04-26
 */
@RestController
@RequestMapping("/clientOrder")
@Validated
public class ClientOrderController {

    private static final Logger logger = LoggerFactory.getLogger(ClientOrderController.class);

    @Resource
    private ClientOrderService clientOrderService;

    /**
     * clientOrder 新增订单
     * @param orderInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-26
     */
    @PostMapping("addOrder")
    public AppResponse addOrder(OrderInfo orderInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setCreateId(userId);
            return clientOrderService.addOrder(orderInfo);
        }catch (Exception e){
            logger.error("新增订单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientOrder 查询订单列表
     * @param orderVo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-26
     */
    @RequestMapping(value = "listOrder")
    public AppResponse listOrder(OrderVo orderVo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            orderVo.setUserId(userId);
            return clientOrderService.listOrder(orderVo);
        }catch (Exception e){
            logger.error("查询订单列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientOrder 修改订单状态
     * @param orderStateInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-26
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(OrderStateInfo orderStateInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            orderStateInfo.setUserId(userId);
            return clientOrderService.updateOrderState(orderStateInfo);
        }catch (Exception e){
            logger.error("修改订单状态错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientOrder 查询订单详情
     * @param orderId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-26
     */
    @RequestMapping(value = "listOrderDeepen")
    public AppResponse listOrderDeepen(String orderId){
        try{
            return clientOrderService.listOrderDeepen(orderId);
        }catch (Exception e){
            logger.error("查询订单详情失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientOrder 查询订单评价商品信息列表
     * @param orderId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-26
     */
    @RequestMapping(value = "listGoodsForEvaluate")
    public AppResponse listGoodsForEvaluate(String orderId){
        try{
            return clientOrderService.listGoodsForEvaluate(orderId);
        }catch (Exception e){
            logger.error("查询订单评价商品信息列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientOrder 新增订单商品评价
     * @param evaluateOrder
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-27
     */
    @PostMapping("addGoodsEvaluate")
    public AppResponse addGoodsEvaluate(@RequestBody JSONObject orderEvaluate){
        try{
            JSONObject orderEvaluateJson = orderEvaluate.getJSONObject("orderEvaluate");
            EvaluateInfo evaluateInfo = orderEvaluate.toJavaObject(orderEvaluateJson,EvaluateInfo.class);
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return clientOrderService.addGoodsEvaluate(evaluateInfo,userId);
        }catch (Exception e){
            logger.error("新增订单商品评价失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
