package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;

import com.xzsd.pc.user.entity.UserVo;
import com.xzsd.pc.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 实现类
 * panzehao
 * 2020-03-24
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * user 新增用户
     * userInfo
     * panzehao
     * 2020-03-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo){
        //检验账号或手机号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if(0 != countUserAcct){
            return AppResponse.bizError("用户账号已存在或手机号已存在，请重新输入！");
        }
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        //密码加密
        String pwd = PasswordUtils.generatePassword(userInfo.getPassword());
        userInfo.setPassword(pwd);
        //新增用户
        int count = userDao.addUser(userInfo);
        if(0 == count){
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * user 删除用户
     * @param userCode
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userCode,String userId){
        List<String> listCode = Arrays.asList(userCode.split(","));
        //删除用户
        int count = userDao.deleteUser(listCode,userId);
        if (0 == count){
            return AppResponse.versionError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * user 修改用户
     * @param userInfo
     * @return
     * @author panzehao
     * @date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo){
        //校验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if(0 != countUserAcct){
            return AppResponse.bizError("用户账号已存在或手机号已存在，请重新输入！");
        }
        //密码加密
        String pwd = PasswordUtils.generatePassword(userInfo.getPassword());
        userInfo.setPassword(pwd);
        //修改用户信息
        int count = userDao.updateUser(userInfo);
        if (0 == count){
            return AppResponse.versionError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * user 查询用户列表（分页）
     * @param userInfo
     * @return
     * @author panzehao
     * @date 2020-03-25
     */
    public AppResponse listUsers(UserInfo userInfo){
        PageHelper.startPage(userInfo.getPageNum(),userInfo.getPageSize());
        List<UserVo> userVoList = userDao.listUsers(userInfo);
        //包装Page对象
        PageInfo<UserVo> pageData = new PageInfo<>(userVoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * user 查询用户详情
     * @param userCode
     * @return
     * @author panzehao
     * @date 2020-03-25
     */
    public AppResponse getUser(String userCode){
        UserInfo userInfo = userDao.getUser(userCode);
        return AppResponse.success("查询成功！",userInfo);
    }
}
