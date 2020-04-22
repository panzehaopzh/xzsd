package com.xzsd.app.userInformation.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.userInformation.dao.UserInformationDao;
import com.xzsd.app.userInformation.entity.PasswordInfo;
import com.xzsd.app.userInformation.entity.UserInfo;
import com.xzsd.app.utils.PasswordUtils;
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
        //获取当前登录用户的角色
        String role = userInformationDao.getUserRole(userId);
        UserInfo userInfo = userInformationDao.getUser(userId,role);
        return AppResponse.success("查询成功！",userInfo);
    }

    /**
     * userInformation 修改个人密码
     * @param passwordInfo
     * @return
     * @author panzehao
     * @date 2020-04-22
     */
    public AppResponse updatePassword(PasswordInfo passwordInfo){
        //校验原密码是否正确
        if(null != passwordInfo.getPassword() && !"".equals(passwordInfo.getPassword())){
            //未加密密码
            String oldPassword = passwordInfo.getPassword();
            //已加密密码
            PasswordInfo pwdInfo = userInformationDao.getPassword(passwordInfo);
            String newPassword = pwdInfo.getPassword();
            if(!PasswordUtils.passwordMatch(oldPassword,newPassword)){
                return AppResponse.bizError("原密码不匹配，请重新输入！");
            }
            passwordInfo.setVersion(pwdInfo.getVersion());
        }
        //密码加密
        passwordInfo.setNewPassword(PasswordUtils.generatePassword(passwordInfo.getNewPassword()));
        //修改密码
        int count = userInformationDao.updatePassword(passwordInfo);
        if(0 == count){
            return AppResponse.versionError("修改密码失败，请重试！");
        }
        return AppResponse.success("修改密码成功！");
    }

}
