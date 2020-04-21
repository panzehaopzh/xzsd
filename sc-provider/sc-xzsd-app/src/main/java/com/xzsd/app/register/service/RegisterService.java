package com.xzsd.app.register.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName RegisterService
 * @Description 注册
 * @author panzehao
 * @date 2020-04-21
 */
@Service
public class RegisterService {

    @Resource
    private RegisterDao registerDao;

    /**
     * register 注册
     * @param registerInfo
     * @return
     * @author panzehao
     * @date 2020-04-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse clientRegister(RegisterInfo registerInfo){
        //检验用户名，手机号和身份证是否已存在
        int countRegister = registerDao.countRegister(registerInfo);
        if(0 != countRegister){
            return AppResponse.bizError("该用户名或手机号或身份证号已存在，请重新输入！");
        }
        registerInfo.setUserCode(StringUtil.getCommonCode(2));
        //密码加密
        registerInfo.setPassword(PasswordUtils.generatePassword(registerInfo.getPassword()));
        //注册用户
        int count1 = registerDao.clientRegister(registerInfo);
        //新增用户到客户表
        int count2 = registerDao.addCustomer(registerInfo);
        if(0 == count1 || 0 == count2){
            return AppResponse.versionError("注册失败，请重试！");
        }
        return AppResponse.success("注册成功！");
    }
}
