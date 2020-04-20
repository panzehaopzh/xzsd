package com.xzsd.pc.menu.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuVo;
import com.xzsd.pc.user.dao.UserDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName MenuService
 * @Description 菜单管理
 * @author panzehao
 * @date 2020-04-14
 */
@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    @Resource
    private UserDao userDao;

    /**
     * menu 查询菜单名列表
     * @param
     * @return
     * @author panzehao
     * @date 2020-04-13
     */
    public AppResponse listMenu(){
        List<MenuVo> menuVoList = menuDao.listMenu();
        return AppResponse.success("查询成功！",menuVoList);
    }

    /**
     * menu 根据角色查询首页菜单列表
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-13
     */
    public AppResponse listMenuHome(String userId){
        String role = userDao.getRoleById(userId);
        List<MenuVo> menuVoList = menuDao.listMenuHome(role);
        return AppResponse.success("查询成功！",menuVoList);
    }

    /**
     * 新增菜单
     * @param menuInfo
     * @return
     * @author panzehao
     * @date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuInfo menuInfo){
        //判断菜单名称是否存在
        int countMenuName = menuDao.countMenuName(menuInfo);
        if(0 != countMenuName){
            return AppResponse.bizError("菜单名称已存在，请重新输入！");
        }
        menuInfo.setMenuCode(StringUtil.getCommonCode(2));
        int count = menuDao.addMenu(menuInfo);
        if(0 == count){
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询菜单详情
     * @param menuCode
     * @return
     * @author panzehao
     * @date 2020-04-13
     */
    public AppResponse getMenu(String menuCode){
        MenuVo menuVo = menuDao.getMenu(menuCode);
        return AppResponse.success("查询成功！",menuVo);
    }

    /**
     * 修改菜单
     * @param menuInfo
     * @return
     * @author panzehao
     * @date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(MenuInfo menuInfo){
        //判断菜单名称是否存在
        int countMenuName = menuDao.countMenuName(menuInfo);
        if(0 != countMenuName){
            return AppResponse.bizError("菜单名称已存在，请重新输入！");
        }
        int count = menuDao.updateMenu(menuInfo);
        if(0 == count){
            return AppResponse.versionError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 删除菜单
     * @param menuCode
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuCode,String userId){
        int count = menuDao.deleteMenu(menuCode,userId);
        if(0 == count){
            return AppResponse.versionError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
}
