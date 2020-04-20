package com.xzsd.pc.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.store.entity.StoreInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping("/driver")
@Validated
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    /**
     * driver 新增司机信息
     * @param driverInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @PostMapping("/addDriver")
    public AppResponse addDriver(DriverInfo driverInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setCreateId(userId);
            return driverService.addDriver(driverInfo);
        }catch (Exception e){
            logger.error("司机新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * driver 修改司机信息
     * @param driverInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @PostMapping("/updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setUpdateId(userId);
            return driverService.updateDriver(driverInfo);
        }catch (Exception e){
            logger.error("修改司机信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * driver 删除司机信息
     * @param driverCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @PostMapping("/deleteDriver")
    public AppResponse deleteDriver(String driverCode){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriver(driverCode,userId);
        }catch (Exception e){
            logger.error("司机信息删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * driver 查询司机信息详情
     * @param driverCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @RequestMapping(value = "getDriver")
    public AppResponse getDriver(String driverCode){
        try{
            return driverService.getDriver(driverCode);
        }catch (Exception e){
            logger.error("查询司机信息详情失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * driver 查询司机信息列表
     * @param driverInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @RequestMapping(value = "listDriver")
    public AppResponse listDriver(DriverInfo driverInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setUserId(userId);
            return driverService.listDriver(driverInfo);
        }catch (Exception e){
            logger.error("查询司机信息列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
