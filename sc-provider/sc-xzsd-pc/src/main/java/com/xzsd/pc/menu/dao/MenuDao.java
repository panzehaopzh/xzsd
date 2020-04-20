package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName MenuDao
 * @Description menu
 * @author panzehao
 * @date 2020-04-14
 */
@Mapper
public interface MenuDao {
    /**
     * 查询菜单名列表
     * @param
     * @return
     */
    List<MenuVo> listMenu();

    /**
     * 根据角色查询首页菜单列表
     * @param role
     * @return
     */
    List<MenuVo> listMenuHome(@Param("role") String role);

    /**
     * 统计菜单名称
     * @param menuInfo
     * @return
     */
    int countMenuName(MenuInfo menuInfo);

    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    int addMenu(MenuInfo menuInfo);

    /**
     * 查询菜单详情
     * @param menuCode
     * @return
     */
    MenuVo getMenu(@Param("menuCode") String menuCode);

    /**
     * 修改菜单
     * @param menuInfo
     * @return
     */
    int updateMenu(MenuInfo menuInfo);

    /**
     * 删除菜单
     * @param menuCode
     * @param userId
     * @return
     */
    int deleteMenu(@Param("menuCode") String menuCode,@Param("userId") String userId);

}
