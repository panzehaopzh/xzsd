package com.xzsd.app.register.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.register.service.RegisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName RegisterController
 * @Description 注册
 * @author panzehao
 * @date 2020-04-21
 */
@RestController
@RequestMapping("/register")
@Validated
public class RegisterController {

    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Resource
    private RegisterService registerService;

    /**
     * register 注册
     * @param registerInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-21
     */
    @PostMapping("/clientRegister")
    public AppResponse clientRegister(RegisterInfo registerInfo){
        try{
            return registerService.clientRegister(registerInfo);
        }catch (Exception e){
            logger.error("用户注册失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
