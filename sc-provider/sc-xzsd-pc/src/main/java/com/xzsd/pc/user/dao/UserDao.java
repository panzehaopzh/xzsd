package com.xzsd.pc.user.dao;

import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName UserDao
 * @Description user
 * @author panzehao
 * @date 2020-03-24
 */
@Mapper
public interface UserDao {
    /**
     * 统计用户账号数量
     * userInfo 用户信息
     */
    int countUserAcct(UserInfo userInfo);

    /**
     * 根据id获取角色
     * @param userId
     * @return
     */
    String getRoleById(@Param("userId") String userId);

    /**
     * 新增用户
     * userInfo 用户信息
     */
    int addUser(UserInfo userInfo);

    /**
     * 删除用户信息
     * @param listCode 选中的用户编号集合
     * @param userId 更新人
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     *修改用户信息
     * @param userInfo 用户信息
     * @return
     */
    int updateUser(UserInfo userInfo);

    /**
     * 获取所有用户信息
     * @param userInfo 用户信息
     * @return 所有用户信息
     */
    List<UserVo> listUsers(UserInfo userInfo);

    /**
     * 查询用户信息
     * @param userCode 用户编号
     * @return
     */
    UserInfo getUser(@Param("userCode") String userCode);
}
