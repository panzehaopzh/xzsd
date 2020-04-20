package com.xzsd.pc.order.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDetailInfo;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderVo;
import com.xzsd.pc.user.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName OrderService
 * @Description 订单管理
 * @author panzehao
 * @date 2020-04-13
 */
@Service
public class OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private UserDao userDao;

    /**
     * order 查询订单详情
     * @param orderCode
     * @return
     * @author panzehao
     * @date 2020-04-13
     */
    public AppResponse getListOrder(String orderCode){
        List<OrderDetailInfo> orderDetailInfoList = orderDao.getListOrder(orderCode);
        return AppResponse.success("查询成功！",orderDetailInfoList);
    }

    /**
     * order 查询订单列表
     * @param orderInfo
     * @return
     * @author panzehao
     * @date 2020-04-13
     */
    public AppResponse listOrder(OrderInfo orderInfo){
        //获取登录用户角色
        String role = userDao.getRoleById(orderInfo.getUserId());
        orderInfo.setRole(role);
        List<OrderVo> orderVoList = orderDao.listOrder(orderInfo);
        return AppResponse.success("查询成功！",orderVoList);
    }

    /**
     * order 修改订单状态
     * @param orderCode
     * @param orderState
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(String orderCode,String orderState,String userId){
        List<String> listCode = Arrays.asList(orderCode.split(","));
        int count = orderDao.updateOrderState(listCode,orderState,userId);
        if(0 == count){
            return AppResponse.versionError("订单状态修改失败，请重试！");
        }
        return AppResponse.success("订单状态修改成功！");
    }
}
