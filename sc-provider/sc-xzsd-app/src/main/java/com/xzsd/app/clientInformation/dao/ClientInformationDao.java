package com.xzsd.app.clientInformation.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName ClientInformationDao
 * @Description clientInformation
 * @author panzehao
 * @date 2020-04-23
 */
@Mapper
public interface ClientInformationDao {
    /**
     * 查询邀请码是否存在
     * @param inviteCode
     * @return
     */
    int countInviteCode(@Param("inviteCode") String inviteCode);

    /**
     * 修改门店邀请码
     * @param inviteCode
     * @param userId
     * @return
     */
    int updateClientInvite(@Param("inviteCode") String inviteCode,@Param("userId") String userId);
}
