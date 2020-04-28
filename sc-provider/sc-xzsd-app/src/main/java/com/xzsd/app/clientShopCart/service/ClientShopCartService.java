package com.xzsd.app.clientShopCart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientShopCart.dao.ClientShopCartDao;
import com.xzsd.app.clientShopCart.entity.ShopCartInfo;
import com.xzsd.app.clientShopCart.entity.ShopCartVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ClientShopCartService
 * @Description 购物车
 * @author panzehao
 * @date 2020-04-23
 */
@Service
public class ClientShopCartService {

    @Resource
    private ClientShopCartDao clientShopCartDao;

    /**
     * clientShopCart 新增购物车
     * @param shopCartInfo
     * @return
     * @author panzehao
     * @date 2020-04-23
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse addShoppingCart(ShopCartInfo shopCartInfo){
        //检验商品库存
        int goodsStock = clientShopCartDao.getGoodsStock(shopCartInfo);
        if(goodsStock < shopCartInfo.getCartGoodsCount()){
            return AppResponse.bizError("该商品的库存不足，请重新选择数量！");
        }
        //检验商品是否存在于购物车中
        String shopCartId = clientShopCartDao.countShopCartGoods(shopCartInfo);
        if(shopCartId != null &&  !"".equals(shopCartId)){
            shopCartInfo.setShopCartId(shopCartId);
            int updateGoodsCount = clientShopCartDao.updateGoodsCount(shopCartInfo);
            if(0 == updateGoodsCount){
                return AppResponse.versionError("新增购物车失败，请重试！");
            }
            return AppResponse.success("新增购物车成功！");
        }
        shopCartInfo.setShopCartId(StringUtil.getCommonCode(3));
        //新增购物车
        int count = clientShopCartDao.addShoppingCart(shopCartInfo);
        if(0 == count){
            return AppResponse.versionError("新增购物车失败，请重试！");
        }
        return AppResponse.success("新增购物车成功！");
    }

    /**
     * clientShopCart 查询购物车
     * @param pageSize
     * @param pageNum
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-24
     */
    public AppResponse listShoppingCarts(int pageSize,int pageNum,String userId){
        PageHelper.startPage(pageNum,pageSize);
        List<ShopCartVo> shopCartVoList = clientShopCartDao.listShoppingCarts(userId);
        //包装Page对象
        PageInfo<ShopCartVo> pageData = new PageInfo<ShopCartVo>(shopCartVoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * clientShopCart 修改购物车
     * @param shopCartInfo
     * @return
     * @author panzehao
     * @date 2020-04-24
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateShoppingCart(ShopCartInfo shopCartInfo){
        //检验商品库存
        int goodsStock = clientShopCartDao.getGoodsStock(shopCartInfo);
        if(goodsStock < shopCartInfo.getCartGoodsCount()){
            return AppResponse.bizError("该商品的库存不足，请重新选择数量！");
        }
        int count = clientShopCartDao.updateShoppingCart(shopCartInfo);
        if(0 == count){
            return AppResponse.versionError("购物车修改失败，请重试");
        }
        return AppResponse.success("修改购物车成功！");
    }

    /**
     * clientShopCart 删除购物车
     * @param shopCartId
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-24
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse deleteShoppingCart(String shopCartId,String userId){
        List<String> listCode = Arrays.asList(shopCartId.split(","));
        int count = clientShopCartDao.deleteShoppingCart(listCode,userId);
        if(0 == count){
            return AppResponse.versionError("删除失败，请重试！");
        }
        return AppResponse.success("删除购物车成功！");
    }
}
