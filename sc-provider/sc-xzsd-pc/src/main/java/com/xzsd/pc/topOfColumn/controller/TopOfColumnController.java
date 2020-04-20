package com.xzsd.pc.topOfColumn.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.topOfColumn.service.TopOfColumnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName TopOfColumnController
 * @Description 顶部栏
 * @author panzehao
 * @date 2020-04-15
 */
@RestController
@RequestMapping("/topOfColumn")
@Validated
public class TopOfColumnController {

    private static final Logger logger = LoggerFactory.getLogger(TopOfColumnController.class);

    @Resource
    private TopOfColumnService topOfColumnService;

    /**
     * topOfColumn 获取顶部栏用户信息
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-15
     */
    @RequestMapping(value = "getTopOfColumn")
    public AppResponse getTopOfColumn(){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return topOfColumnService.getTopOfColumn(userId);
        }catch (Exception e){
            logger.error("获取顶部栏用户信息失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
