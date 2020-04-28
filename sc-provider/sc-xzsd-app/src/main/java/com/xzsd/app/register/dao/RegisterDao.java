package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName RegisterDao
 * @Description register
 * @author panzehao
 * @date 2020-04-21
 */
@Mapper
public interface RegisterDao {
    /**
     * 检验用户名，手机号和身份证是否已存在
     * @param registerInfo
     * @return
     */
    int countRegister(RegisterInfo registerInfo);

    /**
     * 检验邀请码是否存在
     * @param registerInfo
     * @return
     */
    int countInviteCode(RegisterInfo registerInfo);

    /**
     * 注册用户
     * @param registerInfo
     * @return
     */
    int clientRegister(RegisterInfo registerInfo);

    /**
     * 新增用户到客户表
     * @param registerInfo
     * @return
     */
    int addCustomer(RegisterInfo registerInfo);
}
