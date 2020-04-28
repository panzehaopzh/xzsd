package com.xzsd.app.clientInformation.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientInformation.dao.ClientInformationDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName ClientInformationService
 * @Description 我的（客户个人信息）
 * @author panzehao
 * @date 2020-04-23
 */
@Service
public class ClientInformationService {

    @Resource
    private ClientInformationDao clientInformationDao;

    /**
     * clientInformation 修改邀请码
     * @param inviteCode
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-23
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateClientInvite(String inviteCode,String userId){
        //检验邀请码是否存在
        int countInviteCode = clientInformationDao.countInviteCode(inviteCode);
        if(0 == countInviteCode){
            return AppResponse.bizError("邀请码不存在，请重新输入！");
        }
        //修改邀请码
        int count = clientInformationDao.updateClientInvite(inviteCode,userId);
        if(0 == count){
            return AppResponse.versionError("修改门店邀请码失败，请重试！");
        }
        return AppResponse.success("修改门店邀请码成功！");
    }
}
