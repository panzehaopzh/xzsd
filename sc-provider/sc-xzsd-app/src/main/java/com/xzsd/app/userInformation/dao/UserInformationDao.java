package com.xzsd.app.userInformation.dao;

import com.xzsd.app.userInformation.entity.PasswordInfo;
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
     * 查询登录用户角色
     * @param userId
     * @return
     */
    String getUserRole(@Param("userId") String userId);

    /**
     * 查询个人信息
     * @param userId
     * @param role
     * @return
     */
    UserInfo getUser(@Param("userId") String userId,@Param("role") String role);

    /**
     * 查询原密码
     * @param passwordInfo
     * @return
     */
    PasswordInfo getPassword(PasswordInfo passwordInfo);

    /**
     * 修改个人密码
     * @param passwordInfo
     * @return
     */
    int updatePassword(PasswordInfo passwordInfo);
}
