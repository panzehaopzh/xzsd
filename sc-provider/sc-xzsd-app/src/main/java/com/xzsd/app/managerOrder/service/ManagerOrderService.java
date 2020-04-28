package com.xzsd.app.managerOrder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.managerOrder.dao.ManagerOrderDao;
import com.xzsd.app.managerOrder.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ManagerOrderService
 * @Description 店长订单
 * @author panzehao
 * @date 2020-04-25
 */
@Service
public class ManagerOrderService {

    @Resource
    private ManagerOrderDao managerOrderDao;

    /**
     * managerOrder 查询店长订单列表
     * @param managerOrderVo
     * @return
     * @author panzehao
     * @date 2020-04-25
     */
    public AppResponse listManagerOrders(ManagerOrderVo managerOrderVo){
        PageHelper.startPage(managerOrderVo.getPageNum(),managerOrderVo.getPageSize());
        List<ManagerOrderInfo> managerOrderInfoList = managerOrderDao.listManagerOrders(managerOrderVo);
        //包装Page对象
        PageInfo<ManagerOrderInfo> pageData = new PageInfo<ManagerOrderInfo>(managerOrderInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * managerOrder 修改店长订单状态
     * @param orderStateInfo
     * @return
     * @author panzehao
     * @date 2020-04-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateManagerOrderState(OrderStateInfo orderStateInfo){
        int count = managerOrderDao.updateManagerOrderState(orderStateInfo);
        if(0 == count){
            return AppResponse.versionError("修改订单状态失败，请重试！");
        }
        return AppResponse.success("修改订单状态成功！");
    }

    /**
     * managerOrder 查询店长订单详情
     * @param orderId
     * @return
     * @author panzehao
     * @date 2020-04-25
     */
    public AppResponse listManagerOrderDeepen(String orderId){
        OrderDetailInfo orderDetailInfo = managerOrderDao.listManagerOrderDeepen(orderId);
        return AppResponse.success("查询成功" ,orderDetailInfo);
    }
}
