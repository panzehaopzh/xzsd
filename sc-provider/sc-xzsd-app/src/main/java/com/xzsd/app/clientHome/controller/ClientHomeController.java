package com.xzsd.app.clientHome.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientHome.service.ClientHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ClientHomeController
 * @Description 客户端首页
 * @author panzehao
 * @date 2020-04-22
 */
@RestController
@RequestMapping("/clientHome")
@Validated
public class ClientHomeController {

    private static final Logger logger = LoggerFactory.getLogger(ClientHomeController.class);

    @Resource
    private ClientHomeService clientHomeService;

    /**
     * clientHome 查询首页轮播图
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-22
     */
    @RequestMapping(value = "listRotationChartHome")
    public AppResponse listRotationChartHome(){
        try{
            return clientHomeService.listRotationChartHome();
        }catch (Exception e){
            logger.error("首页轮播图查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientHome 查询首页热门商品
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-22
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(){
        try{
            return clientHomeService.listHotGoods();
        }catch (Exception e){
            logger.error("首页热门商品查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
