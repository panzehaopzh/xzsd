package com.xzsd.pc.rotationChart.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.rotationChart.entity.RotationChartInfo;
import com.xzsd.pc.rotationChart.entity.RotationGoodsVo;
import com.xzsd.pc.rotationChart.service.RotationChartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName RotationChartController
 * @Description 轮播图管理
 * @author panzehao
 * @date 2020-04-10
 */
@RestController
@RequestMapping("/rotationChart")
@Validated
public class RotationChartController {

    private static final Logger logger = LoggerFactory.getLogger(RotationChartController.class);

    @Resource
    private RotationChartService rotationChartService;

    /**
     * RotationChartInfo 新增轮播图
     * @param rotationChartInfo
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    @PostMapping("addRotationChart")
    public AppResponse addRotationChart(RotationChartInfo rotationChartInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            rotationChartInfo.setCreateId(userId);
            return rotationChartService.addRotationChart(rotationChartInfo);
        }catch (Exception e){
            logger.error("轮播图新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * RotationChartInfo 查询轮播图商品列表
     * @param rotationGoodsVo
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    @PostMapping("listRotationGoods")
    public AppResponse listRotationGoods(RotationGoodsVo rotationGoodsVo){
        try{
            return rotationChartService.listRotationGoods(rotationGoodsVo);
        }catch (Exception e){
            logger.error("商品列表获取异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * RotationChartInfo 删除轮播图
     * @param chartId
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    @PostMapping("deleteRotationChart")
    public AppResponse deleteRotationChart(String chartId){
        try{
            String userId = SecurityUtils.getCurrentUserId();
            return rotationChartService.deleteRotationChart(chartId,userId);
        }catch (Exception e){
            logger.error("轮播图删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * RotationChartInfo 查询轮播图状态
     * @param rotationChartInfo
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    @PostMapping("listRotationChartState")
    public AppResponse listRotationChartState(RotationChartInfo rotationChartInfo){
        try{
            return rotationChartService.listRotationChartState(rotationChartInfo);
        }catch (Exception e){
            logger.error("轮播图列表获取异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * RotationChartInfo 轮播图状态修改
     * @param chartId
     * @param chartState
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    @PostMapping("updateRotationChartState")
    public AppResponse updateRotationChartState(String chartId,String chartState){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return rotationChartService.updateRotationChartState(chartId,chartState,userId);
        }catch (Exception e){
            logger.error("轮播图状态修改异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
