package com.xzsd.pc.goods.dao;

import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.SortInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GoodsDao
 * @Description goods
 * @author panzehao
 * @date 2020-03-30
 */
@Mapper
public interface GoodsDao {

    /**
     * 统计书号数量
     * goodsInfo 商品信息
     */
    int countISBM(GoodsInfo goodsInfo);

    /**
     * 新增商品
     * @param goodsInfo 商品信息
     * @return
     */
    int addGoods(GoodsInfo goodsInfo);

    /**
     * 查询在轮播图和热门商品的商品编号
     * @param listCode 选中的商品编号集合
     * @return
     */
    List<String> listHotChart(@Param("listCode") List<String> listCode);

    /**
     * 查询在轮播图和热门商品的商品名称
     * @param listCode 选中的商品编号集合
     * @return
     */
    List<String> listGoodsName(@Param("listCode") List<String> listCode);

    /**
     * 删除商品
     * @param listCode 选中的商品编号集合
     * @param userId 更新人
     * @return
     */
    int deleteGoods(@Param("listCode")List<String> listCode, @Param("userId") String userId);

    /**
     * 修改商品信息
     * @param goodsInfo 商品信息
     * @return 修改成果
     */
    int updateGoods(GoodsInfo goodsInfo);

    /**
     * 查询商品信息
     * @param goodsCode 商品编号
     * @return 查询结果
     */
    GoodsInfo getGoods(@Param("goodsCode") String goodsCode);

    /**
     * 获取所有商品信息
     * @param goodsInfo 商品信息
     * @return 所有商品信息
     */
    List<GoodsInfo> listGoods(GoodsInfo goodsInfo);

    /**
     * 商品上架下架修改
     * @param listCode 选中的商品编号集合
     * @param goodsState 商品状态
     * @param userId 更新人
     * @return
     */
    int updateGoodsState(@Param("listCode")List<String> listCode, @Param("goodsState") String goodsState,@Param("userId") String userId);

    /**
     * 查询商品分类下拉框
     * @param sortId
     * @return 所有对应级数的商品分类信息
     */
    List<SortInfo> listSort(@Param("sortId") String sortId);

}
