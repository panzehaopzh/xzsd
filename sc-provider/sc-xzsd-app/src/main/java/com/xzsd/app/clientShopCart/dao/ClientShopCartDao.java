package com.xzsd.app.clientShopCart.dao;

import com.xzsd.app.clientShopCart.entity.ShopCartInfo;
import com.xzsd.app.clientShopCart.entity.ShopCartVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ClientShopCartDao
 * @Description clientShopCart
 * @author panzehao
 * @date 2020-04-23
 */
@Mapper
public interface ClientShopCartDao {
    /**
     * 查询商品是否已存在于购物车中
     * @param shopCartInfo
     * @return
     */
    String countShopCartGoods(ShopCartInfo shopCartInfo);

    /**
     * 查询商品库存
     * @param shopCartInfo
     * @return
     */
    int getGoodsStock(ShopCartInfo shopCartInfo);

    /**
     * 增加购物车商品数量
     * @param shopCartInfo
     * @return
     */
    int updateGoodsCount(ShopCartInfo shopCartInfo);

    /**
     * 新增购物车
     * @param shopCartInfo
     * @return
     */
    int addShoppingCart(ShopCartInfo shopCartInfo);

    /**
     * 查询购物车
     * @param userId
     * @return
     */
    List<ShopCartVo> listShoppingCarts(@Param("userId") String userId);

    /**
     * 修改购物车
     * @param shopCartInfo
     * @return
     */
    int updateShoppingCart(ShopCartInfo shopCartInfo);

    /**
     * 删除购物车
     * @param listCode
     * @param userId
     * @return
     */
    int deleteShoppingCart(@Param("listCode")List<String> listCode,@Param("userId") String userId);
}
