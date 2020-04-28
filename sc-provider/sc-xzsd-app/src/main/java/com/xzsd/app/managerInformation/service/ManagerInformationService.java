package com.xzsd.app.managerInformation.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.managerInformation.dao.ManagerInformationDao;
import com.xzsd.app.managerInformation.entity.DriverInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ManagerInformationService
 * @Description 店长端
 * @author panzehao
 * @date 2020-04-23
 */
@Service
public class ManagerInformationService {

    @Resource
    private ManagerInformationDao managerInformationDao;

    /**
     * managerInformation 查询店长门下的司机信息
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-23
     */
    public AppResponse listManagerDrivers(String userId){
        List<DriverInfo> driverInfoList = managerInformationDao.listManagerDrivers(userId);
        return AppResponse.success("查询成功！",driverInfoList);
    }
}
