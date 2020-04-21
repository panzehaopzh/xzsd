package com.xzsd.pc.goodsSort.dao;

import com.xzsd.pc.goodsSort.entity.FirstSort;
import com.xzsd.pc.goodsSort.entity.GoodsSortInfo;
import com.xzsd.pc.goodsSort.entity.GoodsSortVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName GoodsSortDao
 * @Description goodsSort
 * @author panzehao
 * @date 2020-04-08
 */
@Mapper
public interface GoodsSortDao {
    /**
     * 新增商品分类
     * goodsSortInfo
     */
    int addGoodsSort(GoodsSortInfo goodsSortInfo);

    /**
     * 修改商品分类
     * @param goodsSortInfo 商品分类信息
     * @return
     */
    int updateGoodsSort(GoodsSortInfo goodsSortInfo);

    /**
     * 查询商品分类是否有子分类
     * @param sortId 选中的商品分类编号
     * @return
     */
    int countSubcategory(@Param("sortId") String sortId);

    /**
     * 查询商品分类是否有商品
     * @param sortId 选中的商品分类编号
     * @return
     */
    int countGoods(@Param("sortId") String sortId);

    /**
     * 删除商品分类
     * @param sortId 选中的商品分类编号
     * @param userId 更新人
     * @return
     */
    int deleteGoodsSort(@Param("sortId") String sortId, @Param("userId") String userId);

    /**
     * 获取所有商品分类信息
     * @param
     * @return 所有商品分类信息
     */
    List<FirstSort> listGoodsSort();

    /**
     * 查询商品分类信息
     * @param sortId 商品分类编号
     * @return
     */
    GoodsSortVo getGoodsSort(@Param("sortId") String sortId);
}
