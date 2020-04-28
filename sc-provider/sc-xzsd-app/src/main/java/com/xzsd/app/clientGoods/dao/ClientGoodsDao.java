package com.xzsd.app.clientGoods.dao;

import com.xzsd.app.clientGoods.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ClientGoodsDao
 * @Description clientGoods
 * @author panzehao
 * @date 2020-04-22
 */
@Mapper
public interface ClientGoodsDao {
    /**
     * 查询商品信息详情
     * @param goodsCode
     * @return
     */
    GoodsInfo getGoods(@Param("goodsCode") String goodsCode);

    /**
     * 查询商品评价列表
     * @param goodsEvaluateInfo
     * @return
     */
    List<GoodsEvaluateInfo> listGoodsEvaluates(GoodsEvaluateInfo goodsEvaluateInfo);

    /**
     * 查询一级商品分类列
     * @param
     * @return
     */
    List<OneClassifyInfo> listOneGoodsClassify();

    /**
     * 查询二级商品分类以及商品
     * @param classifyId 一级商品分类编号
     * @return
     */
    List<TwoClassifyInfo> listGetClassGoods(@Param("classifyId") String classifyId);
}
