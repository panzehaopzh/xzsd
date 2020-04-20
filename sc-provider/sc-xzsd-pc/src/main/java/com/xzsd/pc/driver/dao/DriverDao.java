package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverDTO;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DriverDao
 * @Description driver
 * @author panzehao
 * @date 2020-04-12
 */
@Mapper
public interface DriverDao {
    /**
     * 统计司机账号和联系电话数量
     * @param driverInfo
     * @return
     */
    int countDriverAcct(DriverInfo driverInfo);

    /**
     * 新增司机信息
     * @param driverInfo
     * @return
     */
    int addDriver(DriverInfo driverInfo);

    /**
     * 新增司机信息到用户表
     * @param driverInfo
     * @return
     */
    int addDriverToUser(DriverInfo driverInfo);

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     */
    int updateDriver(DriverInfo driverInfo);

    /**
     * 修改用户表中的司机信息
     * @param driverInfo
     * @return
     */
    int updateDriverToUser(DriverInfo driverInfo);

    /**
     * 删除司机信息
     * @param listCode 选中的司机编号集合
     * @param userId 更新人
     * @return
     */
    int deleteDriver(@Param("listCode") List<String> listCode,@Param("userId") String userId);

    /**
     * 删除用户表中的司机信息
     * @param listCode 选中的司机编号集合
     * @param userId 更新人
     * @return
     */
    int deleteDriverToUser(@Param("listCode") List<String> listCode,@Param("userId") String userId);

    /**
     * 查询司机信息详情
     * @param driverCode
     * @return
     */
    DriverDTO getDriver(@Param("driverCode") String driverCode);

    /**
     * 查询司机列表信息
     * @param driverInfo
     * @return
     */
    List<DriverVo> listDriver(DriverInfo driverInfo);
}
