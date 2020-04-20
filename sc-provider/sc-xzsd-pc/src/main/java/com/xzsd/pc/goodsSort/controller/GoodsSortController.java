package com.xzsd.pc.goodsSort.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.goodsSort.entity.GoodsSortInfo;
import com.xzsd.pc.goodsSort.service.GoodsSortService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName GoodsSortService
 * @Description 商品分类管理
 * @author panzehao
 * @date 2020-04-08
 */
@RestController
@RequestMapping("/goodsSort")
@Validated
public class GoodsSortController {

    private static final Logger logger = LoggerFactory.getLogger(GoodsSortController.class);

    @Resource
    private GoodsSortService goodsSortService;

    /**
     * goodsSort 新增商品分类
     * @param goodsSortInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-08
     */
    @PostMapping("addGoodsSort")
    public AppResponse addGoodsSort(GoodsSortInfo goodsSortInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsSortInfo.setCreateId(userId);
            return goodsSortService.addGoodsSort(goodsSortInfo);
        }catch (Exception e){
            logger.error("商品分类新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goodsSort 修改商品分类
     * @param goodsSortInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-08
     */
    @PostMapping("updateGoodsSort")
    public AppResponse updateGoodsSort(GoodsSortInfo goodsSortInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            goodsSortInfo.setUpdateId(userId);
            return goodsSortService.updateGoodsSort(goodsSortInfo);
        }catch (Exception e){
            logger.error("修改商品分类错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goodsSort 删除商品分类
     * @param sortId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-08
     */
    @PostMapping("deleteGoodsSort")
    public AppResponse deleteGoodsSort(String sortId){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            return goodsSortService.deleteGoodsSort(sortId,userId);
        }catch (Exception e) {
            logger.error("商品分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goodsSort 商品分类列表
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-08
     */
    @RequestMapping(value = "listGoodsSort")
    public AppResponse listGoodsSort(){
        try{
            return goodsSortService.listGoodsSort();
        }catch (Exception e) {
            logger.error("查询商品分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * goodsSort 查询商品分类详情
     * @param sortId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-08
     */
    @RequestMapping(value = "getGoodsSort")
    public AppResponse getGoodsSort(String sortId){
        try{
            return goodsSortService.getGoodsSort(sortId);
        }catch (Exception e) {
            logger.error("商品分类查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
