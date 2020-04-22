package com.xzsd.pc.rotationChart.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.rotationChart.entity.RotationChartInfo;
import com.xzsd.pc.rotationChart.entity.RotationGoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName RotationChartDao
 * @Description 轮播图管理
 * @author panzehao
 * @date 2020-04-09
 */
@Mapper
public interface RotationChartDao {
    /**
     * 统计轮播图商品编号和序号
     * @param rotationChartInfo
     * @return
     */
    int countGoodsCode(RotationChartInfo rotationChartInfo);

    /**
     * 新增轮播图
     * @param rotationChartInfo
     * @return
     */
    int addRotationChart(RotationChartInfo rotationChartInfo);

    /**
     * 查询轮播图商品列表
     * @param rotationGoodsVo
     * @return 商品列表
     */
    List<RotationGoodsVo> listRotationGoods(RotationGoodsVo rotationGoodsVo);

    /**
     * 删除轮播图
     * @param listCode
     * @param userId
     * @return
     */
    int deleteRotationChart(@Param("listCode")List<String> listCode,@Param("userId") String userId);

    /**
     * 查询轮播图状态列表
     * @param rotationChartInfo
     * @return 轮播图列表
     */
    List<RotationChartInfo> listRotationChartState(RotationChartInfo rotationChartInfo);

    /**
     * 轮播图状态修改
     * @param listCode
     * @param chartState
     * @param userId
     * @return
     */
    int updateRotationChartState(@Param("listCode")List<String> listCode,@Param("chartState") String chartState,@Param("userId") String userId);

}
