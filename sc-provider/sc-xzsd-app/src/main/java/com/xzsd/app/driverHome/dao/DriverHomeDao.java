package com.xzsd.app.driverHome.dao;

import com.xzsd.app.driverHome.entity.DriverStoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DriverHomeDao
 * @Description driverHome
 * @author panzehao
 * @date 2020-04-23
 */
@Mapper
public interface DriverHomeDao {
    /**
     * 查询司机负责的门店信息
     * @param userId
     * @return
     */
    List<DriverStoreInfo> listDriverStores(@Param("userId") String userId);
}
