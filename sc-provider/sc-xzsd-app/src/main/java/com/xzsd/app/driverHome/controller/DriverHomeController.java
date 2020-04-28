package com.xzsd.app.driverHome.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driverHome.service.DriverHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName DriverHomeController
 * @Description 司机首页
 * @author panzehao
 * @date 2020-04-23
 */
@RestController
@RequestMapping("/driverHome")
@Validated
public class DriverHomeController {

    private static final Logger logger = LoggerFactory.getLogger(DriverHomeController.class);

    @Resource
    private DriverHomeService driverHomeService;

    /**
     * driverHome 查询司机负责的门店信息
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-23
     */
    @RequestMapping(value = "listDriverStores")
    public AppResponse listDriverStores(){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return driverHomeService.listDriverStores(userId);
        }catch (Exception e){
            logger.error("司机负责的门店信息查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
