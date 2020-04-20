package com.xzsd.pc.order.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.user.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName DriverController
 * @Description 司机信息管理
 * @author panzehao
 * @date 2020-04-12
 */
@RestController
@RequestMapping("/order")
@Validated
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     * order 查询订单详情
     * @param orderCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-13
     */
    @RequestMapping(value = "getListOrder")
    public AppResponse getListOrder(String orderCode){
        try{
            return orderService.getListOrder(orderCode);
        }catch (Exception e){
            logger.error("订单详情查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * order 查询订单列表
     * @param orderInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-13
     */
    @RequestMapping(value = "listOrder")
    public AppResponse listOrder(OrderInfo orderInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setUserId(userId);
            return orderService.listOrder(orderInfo);
        }catch (Exception e){
            logger.error("订单列表查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * order 修改订单状态
     * @param orderCode
     * @param orderState
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-13
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(String orderCode,String orderState){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return orderService.updateOrderState(orderCode,orderState,userId);
        }catch (Exception e){
            logger.error("订单状态修改错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
