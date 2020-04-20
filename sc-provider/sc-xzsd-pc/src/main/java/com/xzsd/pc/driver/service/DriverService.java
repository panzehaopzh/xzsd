package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverDTO;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DriverService
 * @Description 司机信息管理
 * @author panzehao
 * @date 2020-04-12
 */
@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;

    @Resource
    private UserDao userDao;

    /**
     * driver 新增司机
     * @param driverInfo
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo){
        //检验司机账号或联系电话是否存在
        int countDriverAcct = driverDao.countDriverAcct(driverInfo);
        if(0 != countDriverAcct){
            return AppResponse.bizError("司机账号已存在或联系电话已存在，请重新输入！");
        }
        driverInfo.setDriverCode(StringUtil.getCommonCode(2));
        //密码加密
        String pwd = PasswordUtils.generatePassword(driverInfo.getPassword());
        driverInfo.setPassword(pwd);
        //新增司机表司机信息
        int count1 = driverDao.addDriver(driverInfo);
        //新增用户表司机信息
        int count2 = driverDao.addDriverToUser(driverInfo);
        if(0 == count1 || 0 == count2){
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * driver 修改司机信息
     * @param driverInfo
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo){
        //检验司机账号或联系电话是否存在
        int countDriverAcct = driverDao.countDriverAcct(driverInfo);
        if(0 != countDriverAcct){
            return AppResponse.bizError("司机账号已存在或联系电话已存在，请重新输入！");
        }
        //密码加密
        String pwd = PasswordUtils.generatePassword(driverInfo.getPassword());
        driverInfo.setPassword(pwd);
        //修改司机表司机信息
        int count1 = driverDao.updateDriver(driverInfo);
        //修改用户表司机信息
        int count2 = driverDao.updateDriverToUser(driverInfo);
        if(0 == count1 || 0 == count2){
            return AppResponse.bizError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * driver 删除司机信息
     * @param driverCode
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String driverCode,String userId){
        List<String> listCode = Arrays.asList(driverCode.split(","));
        //删除司机表司机信息
        int count1 = driverDao.deleteDriver(listCode,userId);
        //删除用户表司机信息
        int count2 = driverDao.deleteDriverToUser(listCode,userId);
        if(0 == count1 || 0 == count2){
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * driver 查询司机信息详情
     * @param driverCode
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    public AppResponse getDriver(String driverCode){
        DriverDTO driverDTO = driverDao.getDriver(driverCode);
        return AppResponse.success("查询成功！",driverDTO);
    }

    /**
     * driver 查询司机信息列表
     * @param driverInfo
     * @return
     * @author panzehao
     * @date 2020-04-12
     */
    public AppResponse listDriver(DriverInfo driverInfo){
        PageHelper.startPage(driverInfo.getPageNum(),driverInfo.getPageSize());
        //获取登录用户的角色
        driverInfo.setRole(userDao.getRoleById(driverInfo.getUserId()));
        List<DriverVo> driverVoList = driverDao.listDriver(driverInfo);
        //包装Page对象
        PageInfo<DriverVo> pageData = new PageInfo<>(driverVoList);
        return AppResponse.success("查询成功！",pageData);
    }
}
