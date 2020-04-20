package com.xzsd.pc.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @description 增删查改
 * @author panzehao
 * @date 2020-03-24
 */
@RestController
@RequestMapping("/goods")
@Validated
public class GoodsController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * goods 新增商品
     * @param goodsInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-03-30
     */
    @PostMapping("/addGoods")
    public AppResponse addGoods(GoodsInfo goodsInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setCreateId(userId);
            AppResponse appResponse = goodsService.addGoods(goodsInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("商品新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goods 删除商品
     * @param goodsCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-03-30
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsCode){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsCode,userId);
        }catch (Exception e){
            logger.error("商品删除错误！",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goods 修改商品
     * @param goodsInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-03-30
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goodsInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setUpdateId(userId);
            return goodsService.updateGoods(goodsInfo);
        }catch (Exception e){
            logger.error("修改商品信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goods 查询商品详情
     * @param goodsCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-03-30
     */
    @RequestMapping(value = "getGoods")
    public AppResponse getGoods(String goodsCode){
        try{
            return goodsService.getGoods(goodsCode);
        }catch (Exception e){
            logger.error("商品查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goods 商品列表（分页）
     * @param goodsInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-03-30
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodsInfo goodsInfo){
        try{
            return goodsService.listGoods(goodsInfo);
        }catch (Exception e){
            logger.error("查询商品列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goods 商品上架下架修改
     * @param goodsCode
     * @param goodsState
     * @return
     * @author panzehao
     * @date 2020-03-30
     */
    @PostMapping("updateGoodsState")
    public AppResponse updateGoodsState(String goodsCode,String goodsState){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return goodsService.updateGoodsState(goodsCode,goodsState,userId);
        }catch (Exception e){
            logger.error("修改商品状态错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goods 查询商品分类下拉框
     * @param sortId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-08
     */
    @RequestMapping(value = "listSort")
    public AppResponse listSort(String sortId){
        try{
            return goodsService.listSort(sortId);
        }catch (Exception e){
            logger.error("查询商品分类列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
