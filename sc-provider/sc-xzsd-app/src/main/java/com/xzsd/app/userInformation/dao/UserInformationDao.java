package com.xzsd.app.userInformation.dao;

import com.xzsd.app.userInformation.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName UserInformationDao
 * @Description userInformation
 * @author panzehao
 * @date 2020-04-21
 */
@Mapper
public interface UserInformationDao {
    /**
     * 查询个人信息
     * @param userId
     * @return
     */
    UserInfo getUser(@Param("userId") String userId);
}
