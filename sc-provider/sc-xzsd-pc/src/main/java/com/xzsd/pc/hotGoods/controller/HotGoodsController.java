package com.xzsd.pc.hotGoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotGoods.service.HotGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName HotGoodsController
 * @Description 热门位商品管理
 * @author panzehao
 * @date 2020-04-11
 */
@RestController
@RequestMapping("/hotGoods")
@Validated
public class HotGoodsController {

    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    @Resource
    private HotGoodsService hotGoodsService;

    /**
     * hotGoods 新增热门位商品
     * @param hotGoodsInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-11
     */
    @PostMapping("/addHotGoods")
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setCreateId(userId);
            return hotGoodsService.addHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("热门位商品新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotGoods 修改热门位商品
     * @param hotGoodsInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-11
     */
    @PostMapping("/updateHotGoods")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            hotGoodsInfo.setUpdateId(userId);
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("热门位商品修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotGoods 删除热门位商品
     * @param hotId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-11
     */
    @PostMapping("/deleteHotGoods")
    public AppResponse deleteHotGoods(String hotId){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            return hotGoodsService.deleteHotGoods(hotId,userId);
        }catch (Exception e){
            logger.error("热门位商品删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotGoods 查询热门位商品详情
     * @param hotId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-11
     */
    @RequestMapping(value = "getHotGoods")
    public AppResponse getHotGoods(String hotId){
        try{
            return hotGoodsService.getHotGoods(hotId);
        }catch (Exception e){
            logger.error("热门位商品查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotGoods 查询热门位商品列表
     * @param hotGoodsInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-11
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo){
        try{
            return hotGoodsService.listHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("热门位商品列表查询异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotGoods 查询展示数量
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-11
     */
    @RequestMapping(value = "getHotGoodsNum")
    public AppResponse getHotGoodsNum(){
        try{
            return hotGoodsService.getHotGoodsNum();
        }catch (Exception e){
            logger.error("展示数量查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * hotGoods 修改展示数量
     * @param hotGoodsNum
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-11
     */
    @RequestMapping(value = "updateHotGoodsNum")
    public AppResponse updateHotGoodsNum(int hotGoodsNum){
        try{
            return hotGoodsService.updateHotGoodsNum(hotGoodsNum);
        }catch (Exception e){
            logger.error("修改展示数量错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
