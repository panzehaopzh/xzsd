package com.xzsd.pc.customer.controller;

import com.neusoft.core.restful.AppResponse;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.entity.CustomerVo;
import com.xzsd.pc.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @ClassName CustomerController
 * @Description 客户管理
 * @author panzehao
 * @date 2020-04-11
 */
@RestController
@RequestMapping("/customer")
@Validated
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Resource
    private CustomerService customerService;

    /**
     * customer 查询客户列表
     * @param customerVo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-11
     */
    @RequestMapping(value = "listCustomer")
    public AppResponse listCustomer(CustomerVo customerVo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            customerVo.setUserId(userId);
            return customerService.listCustomer(customerVo);
        }catch (Exception e){
            logger.error("查询客户列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
