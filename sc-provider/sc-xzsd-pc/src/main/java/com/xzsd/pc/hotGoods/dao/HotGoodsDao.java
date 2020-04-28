package com.xzsd.pc.hotGoods.dao;


import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotGoods.entity.HotGoodsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName HotGoodsDao
 * @Description hotGoods
 * @author panzehao
 * @date 2020-04-11
 */
@Mapper
public interface HotGoodsDao {
    /**
     * 统计热门位商品编号和热门位排序
     * @param hotGoodsInfo
     * @return
     */
    int countHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 新增热门位商品
     * @param hotGoodsInfo
     * @return
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 修改热门位商品
     * @param hotGoodsInfo
     * @return
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 删除热门位商品
     * @param listCode 选中的热门位商品编号集合
     * @param userId 更新人
     * @return
     */
    int deleteHotGoods(@Param("listCode")List<String> listCode, @Param("userId") String userId);

    /**
     * 查询热门位商品详情
     * @param hotId
     * @return
     */
    HotGoodsInfo getHotGoods(@Param("hotId") String hotId);

    /**
     * 查询热门位商品列表
     * @param hotGoodsInfo
     * @return
     */
    List<HotGoodsVo> listHotGoodsByPage(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询展示数量
     * @param
     * @return
     */
    int getHotGoodsNum();

    /**
     * 修改展示数量
     * @param hotGoodsNum
     * @return
     */
    int updateHotGoodsNum(@Param("hotGoodsNum") int hotGoodsNum);
}
