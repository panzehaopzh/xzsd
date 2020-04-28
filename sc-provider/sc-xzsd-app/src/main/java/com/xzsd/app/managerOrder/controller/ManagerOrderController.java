package com.xzsd.app.managerOrder.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.managerOrder.entity.ManagerOrderVo;
import com.xzsd.app.managerOrder.entity.OrderStateInfo;
import com.xzsd.app.managerOrder.service.ManagerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ManagerOrderController
 * @Description 店长订单
 * @author panzehao
 * @date 2020-04-25
 */
@RestController
@RequestMapping("/managerOrder")
@Validated
public class ManagerOrderController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerOrderController.class);

    @Resource
    private ManagerOrderService managerOrderService;

    /**
     * managerOrder 查询店长订单列表
     * @param managerOrderVo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-25
     */
    @RequestMapping(value = "listManagerOrders")
    public AppResponse listManagerOrders(ManagerOrderVo managerOrderVo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            managerOrderVo.setUserId(userId);
            return managerOrderService.listManagerOrders(managerOrderVo);
        }catch (Exception e){
            logger.error("查询店长订单列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * managerOrder 修改店长订单状态
     * @param orderStateInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-25
     */
    @PostMapping("updateManagerOrderState")
    public AppResponse updateManagerOrderState(OrderStateInfo orderStateInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            orderStateInfo.setUserId(userId);
            return managerOrderService.updateManagerOrderState(orderStateInfo);
        }catch (Exception e){
            logger.error("修改店长订单状态错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * managerOrder 查询店长订单详情
     * @param orderId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-25
     */
    @RequestMapping(value = "listManagerOrderDeepen")
    public AppResponse listManagerOrderDeepen(String orderId){
        try{
            return managerOrderService.listManagerOrderDeepen(orderId);
        }catch (Exception e){
            logger.error("查询订单详情失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
