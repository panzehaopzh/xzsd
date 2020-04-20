package com.xzsd.pc.topOfColumn.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.topOfColumn.dao.TopOfColumnDao;
import com.xzsd.pc.topOfColumn.entity.TopOfColumnInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName TopOfColumnService
 * @Description 顶部栏
 * @author panzehao
 * @date 2020-04-15
 */
@Service
public class TopOfColumnService {

    @Resource
    private TopOfColumnDao topOfColumnDao;

    /**
     * topOfColumn 获取顶部栏用户信息
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-15
     */
    public AppResponse getTopOfColumn(String userId){
        TopOfColumnInfo topOfColumnInfo = topOfColumnDao.getTopOfColumn(userId);
        return AppResponse.success("查询成功！",topOfColumnInfo);
    }
}
