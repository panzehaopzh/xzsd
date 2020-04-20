package com.xzsd.pc.topOfColumn.dao;

import com.xzsd.pc.topOfColumn.entity.TopOfColumnInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName TopOfColumnDao
 * @Description topOfColumn
 * @author panzehao
 * @date 2020-04-15
 */
@Mapper
public interface TopOfColumnDao {
    /**
     * 获取顶部栏用户信息
     * @param userId
     * @return
     */
    TopOfColumnInfo getTopOfColumn(String userId);
}
