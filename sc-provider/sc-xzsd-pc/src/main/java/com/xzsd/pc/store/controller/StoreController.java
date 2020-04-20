package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName StoreController
 * @Description 门店管理
 * @author panzehao
 * @date 2020-04-12
 */
@RestController
@RequestMapping("/store")
@Validated
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;

    /**
     * store 新增门店
     * @param storeInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @PostMapping("/addStore")
    public AppResponse addStore(StoreInfo storeInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateId(userId);
            storeInfo.setUserId(userId);
            return storeService.addStore(storeInfo);
        }catch (Exception e){
            logger.error("门店新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * store 修改门店信息
     * @param storeInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @PostMapping("/updateStore")
    public AppResponse updateStore(StoreInfo storeInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setUpdateId(userId);
            return storeService.updateStore(storeInfo);
        }catch (Exception e){
            logger.error("修改门店信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * store 删除门店
     * @param storeId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @PostMapping("/deleteStore")
    public AppResponse deleteStore(String storeId){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeId,userId);
        }catch (Exception e){
            logger.error("门店删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * store 查询门店信息详情
     * @param storeId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @RequestMapping(value = "getStore")
    public AppResponse getStore(String storeId){
        try{
            return storeService.getStore(storeId);
        }catch (Exception e){
            logger.error("查询门店详情失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * store 查询门店信息列表
     * @param storeInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @RequestMapping(value = "listStore")
    public AppResponse listStore(StoreInfo storeInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setUserId(userId);
            return storeService.listStore(storeInfo);
        }catch (Exception e){
            logger.error("查询门店列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * store 查询省市区列表
     * @param areaId
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-12
     */
    @RequestMapping(value = "listArea")
    public AppResponse listArea(String areaId){
        try{
            return storeService.listArea(areaId);
        }catch (Exception e){
            logger.error("查询省市区列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
