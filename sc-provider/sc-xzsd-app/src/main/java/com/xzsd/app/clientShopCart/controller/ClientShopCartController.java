package com.xzsd.app.clientShopCart.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientShopCart.entity.ShopCartInfo;
import com.xzsd.app.clientShopCart.service.ClientShopCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName ClientShopCartController
 * @Description 购物车
 * @author panzehao
 * @date 2020-04-23
 */
@RestController
@RequestMapping("/clientShopCart")
@Validated
public class ClientShopCartController {

    private static final Logger logger = LoggerFactory.getLogger(ClientShopCartController.class);

    @Resource
    private ClientShopCartService clientShopCartService;

    /**
     * clientShopCart 新增购物车
     * @param shopCartInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-23
     */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(ShopCartInfo shopCartInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            shopCartInfo.setCreateId(userId);
            shopCartInfo.setUpdateId(userId);
            return clientShopCartService.addShoppingCart(shopCartInfo);
        }catch (Exception e){
            logger.error("购物车新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientShopCart 查询购物车
     * @param pageSize
     * @param pageNum
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-24
     */
    @RequestMapping(value = "listShoppingCarts")
    public AppResponse listShoppingCarts(int pageSize,int pageNum){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return clientShopCartService.listShoppingCarts(pageSize,pageNum,userId);
        }catch (Exception e){
            logger.error("购物车查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientShopCart 修改购物车
     * @param shopCartInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-24
     */
    @PostMapping("updateShoppingCart")
    public AppResponse updateShoppingCart(ShopCartInfo shopCartInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            shopCartInfo.setUpdateId(userId);
            return clientShopCartService.updateShoppingCart(shopCartInfo);
        }catch (Exception e){
            logger.error("购物车修改失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * clientShopCart 删除购物车
     * @param shopCartId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-24
     */
    @PostMapping("deleteShoppingCart")
    public AppResponse deleteShoppingCart(String shopCartId){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return clientShopCartService.deleteShoppingCart(shopCartId,userId);
        }catch (Exception e){
            logger.error("购物车删除失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
