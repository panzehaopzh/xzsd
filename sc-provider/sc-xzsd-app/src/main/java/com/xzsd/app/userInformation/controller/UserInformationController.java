package com.xzsd.app.userInformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.register.controller.RegisterController;
import com.xzsd.app.userInformation.service.UserInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserInformationController
 * @Description 用户信息
 * @author panzehao
 * @date 2020-04-21
 */
@RestController
@RequestMapping("/userInformation")
@Validated
public class UserInformationController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private UserInformationService userInformationService;

    /**
     * userInformation 查询个人信息
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-21
     */
    @RequestMapping(value = "getUser")
    public AppResponse getUser(){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return userInformationService.getUser(userId);
        }catch (Exception e){
            logger.error("个人信息查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
