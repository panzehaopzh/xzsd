package com.xzsd.pc.menu.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.UUIDUtils;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName MenuController
 * @Description 菜单管理
 * @author panzehao
 * @date 2020-04-14
 */
@RestController
@RequestMapping("/menu")
@Validated
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;

    /**
     * menu 查询菜单名列表
     * @param
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-13
     */
    @RequestMapping(value = "listMenu")
    public AppResponse listMenu(){
        try{
            return menuService.listMenu();
        }catch (Exception e){
            logger.error("查询菜单列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * menu 根据角色查询首页菜单列表
     * @para
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-13
     */
    @RequestMapping(value = "listMenuHome")
    public AppResponse listMenuHome(){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return menuService.listMenuHome(userId);
        }catch (Exception e){
            logger.error("查询角色首页菜单列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增菜单
     * @param menuInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-13
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuInfo menuInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            menuInfo.setCreateId(userId);
            return menuService.addMenu(menuInfo);
        }catch (Exception e){
            logger.error("菜单新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询菜单详情
     * @param menuCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-13
     */
    @RequestMapping(value = "getMenu")
    public AppResponse getMenu(String menuCode){
        try{
            return menuService.getMenu(menuCode);
        }catch (Exception e){
            logger.error("菜单详情查询失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改菜单
     * @param menuInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-13
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            menuInfo.setUpdateId(userId);
            return menuService.updateMenu(menuInfo);
        }catch (Exception e){
            logger.error("修改菜单信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     * @param menuCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-04-13
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuCode){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return menuService.deleteMenu(menuCode,userId);
        }catch (Exception e){
            logger.error("菜单删除失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
