package com.xzsd.app.clientInformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientInformation.service.ClientInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ClientInformationController
 * @Description 我的（客户个人信息）
 * @author panzehao
 * @date 2020-04-23
 */
@RestController
@RequestMapping("/clientInformation")
@Validated
public class ClientInformationController {

    private static final Logger logger = LoggerFactory.getLogger(ClientInformationController.class);

    @Resource
    private ClientInformationService clientInformationService;

    /**
     * clientInformation 修改邀请码
     * @param inviteCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-23
     */
    @PostMapping("updateClientInvite")
    public AppResponse updateClientInvite(String inviteCode){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return clientInformationService.updateClientInvite(inviteCode,userId);
        }catch (Exception e){
            logger.error("门店邀请码修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
