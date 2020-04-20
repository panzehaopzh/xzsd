package com.xzsd.pc.user.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @description 增删查改
 * @author panzehao
 * @date 2020-03-24
 */
@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * user 新增用户
     * userInfo
     * AppResponse
     * panzehao
     * 2020-03-24
     */
    @PostMapping("addUser")
    public AppResponse addUser(UserInfo userInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setCreateId(userId);
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        }catch(Exception e){
            logger.error("用户新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * user 删除用户
     * @param userCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-03-25
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userCode){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return userService.deleteUser(userCode,userId);
        }catch (Exception e){
            logger.error("用户删除错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * user 修改用户
     * @param userInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-03-25
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo){
        try{
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setUpdateId(userId);
            return userService.updateUser(userInfo);
        }catch (Exception e){
            logger.error("修改用户信息错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * user 用户列表（分页）
     * @param userInfo
     * @return AppResponse
     * @author panzehao
     * @date 2020-03-25
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo){
        try{
            return userService.listUsers(userInfo);
        }catch (Exception e){
            logger.error("查询用户列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * user 查询用户详情
     * @param userCode
     * @return AppResponse
     * @author panzehao
     * @date 2020-03-25
     */
    @RequestMapping(value = "getUser")
    public AppResponse getUser(String userCode){
        try{
            return userService.getUser(userCode);
        }catch (Exception e){
            logger.error("用户查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
