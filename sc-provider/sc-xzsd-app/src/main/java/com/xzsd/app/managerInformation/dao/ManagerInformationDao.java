package com.xzsd.app.managerInformation.dao;

import com.xzsd.app.managerInformation.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ManagerInformationDao
 * @Description managerInformation
 * @author panzehao
 * @date 2020-04-23
 */
@Mapper
public interface ManagerInformationDao {
    /**
     * 查询店长门下的司机信息
     * @param userId
     * @return
     */
    List<DriverInfo> listManagerDrivers(@Param("userId") String userId);
}
