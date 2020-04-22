package com.xzsd.app.clientHome.dao;

import com.xzsd.app.clientHome.entity.HotGoodsInfo;
import com.xzsd.app.clientHome.entity.SlideshowInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ClientHomeDao
 * @Description clientHome
 * @author panzehao
 * @date 2020-04-22
 */
@Mapper
public interface ClientHomeDao {
    /**
     * 查询首页轮播图
     * @param
     * @return
     */
    List<SlideshowInfo> listRotationChartHome();

    /**
     * 查询首页热门商品展示数量
     * @param
     * @return
     */
    int getHotGoodsNum();

    /**
     * 查询首页热门商品
     * @param hotGoodsNum
     * @return
     */
    List<HotGoodsInfo> listHotGoods(@Param("hotGoodsNum") int hotGoodsNum);
}
