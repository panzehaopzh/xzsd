package com.xzsd.app.driverHome.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driverHome.dao.DriverHomeDao;
import com.xzsd.app.driverHome.entity.DriverStoreInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName DriverHomeService
 * @Description 司机首页
 * @author panzehao
 * @date 2020-04-23
 */
@Service
public class DriverHomeService {

    @Resource
    private DriverHomeDao driverHomeDao;

    /**
     * driverHome 查询司机负责的门店信息
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-23
     */
    public AppResponse listDriverStores(String userId){
        List<DriverStoreInfo> driverStoreInfoList = driverHomeDao.listDriverStores(userId);
        return AppResponse.success("查询成功！",driverStoreInfoList);
    }
}
