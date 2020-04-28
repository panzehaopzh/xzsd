package com.xzsd.app.managerInformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.managerInformation.service.ManagerInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ManagerInformationController
 * @Description 店长端
 * @author panzehao
 * @date 2020-04-23
 */
@RestController
@RequestMapping("/managerInformation")
@Validated
public class ManagerInformationController {

    private static final Logger logger = LoggerFactory.getLogger(ManagerInformationController.class);

    @Resource
    private ManagerInformationService managerInformationService;

    /**
     * managerInformation 查询店长门下的司机信息
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-23
     */
    @RequestMapping(value = "listManagerDrivers")
    public AppResponse listManagerDrivers(){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return managerInformationService.listManagerDrivers(userId);
        }catch (Exception e){
            logger.error("店长门下的司机信息查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
