package com.xzsd.app.userInformation.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.userInformation.dao.UserInformationDao;
import com.xzsd.app.userInformation.entity.UserInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName RegisterService
 * @Description 注册
 * @author panzehao
 * @date 2020-04-21
 */
@Service
public class UserInformationService {

    @Resource
    private UserInformationDao userInformationDao;

    /**
     * userInformation 查询个人信息
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-21
     */
    public AppResponse getUser(String userId){
        UserInfo userInfo = userInformationDao.getUser(userId);
        return AppResponse.success("查询成功！",userInfo);
    }
}
