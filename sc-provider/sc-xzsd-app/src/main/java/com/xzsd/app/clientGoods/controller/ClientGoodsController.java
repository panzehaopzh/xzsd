package com.xzsd.app.clientGoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientGoods.entity.GoodsEvaluateInfo;
import com.xzsd.app.clientGoods.service.ClientGoodsService;
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
@RequestMapping("/clientGoods")
@Validated
public class ClientGoodsController {

    private static final Logger logger = LoggerFactory.getLogger(ClientGoodsController.class);

    @Resource
    private ClientGoodsService clientGoodsService;

    /**
     * clientGoods 查询商品信息详情
     * @param goodsCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-22
     */
    @RequestMapping(value = "getGoods")
    public AppResponse getGoods(String goodsCode){
        try{
            return clientGoodsService.getGoods(goodsCode);
        }catch (Exception e){
            logger.error("商品信息详情查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientGoods 查询商品评价列表
     * @param goodsEvaluateInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-24
     */
    public AppResponse listGoodsEvaluates(GoodsEvaluateInfo goodsEvaluateInfo){
        try{
            return clientGoodsService.listGoodsEvaluates(goodsEvaluateInfo);
        }catch (Exception e){
            logger.error("商品评价列表查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientGoods 查询一级商品分类列
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-22
     */
    @RequestMapping(value = "listOneGoodsClassify")
    public AppResponse listOneGoodsClassify(){
        try{
            return clientGoodsService.listOneGoodsClassify();
        }catch (Exception e){
            logger.error("一级商品分类列查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientGoods 查询二级商品分类以及商品
     * @param classifyId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-22
     */
    @RequestMapping(value = "listGetClassGoods")
    public AppResponse listGetClassGoods(String classifyId){
        try{
            return clientGoodsService.listGetClassGoods(classifyId);
        }catch (Exception e){
            logger.error("二级商品分类以及商品查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
