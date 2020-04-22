package com.xzsd.pc.rotationChart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.rotationChart.dao.RotationChartDao;
import com.xzsd.pc.rotationChart.entity.RotationChartInfo;
import com.xzsd.pc.rotationChart.entity.RotationGoodsVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName RotationChartService
 * @Description 轮播图管理
 * @author panzehao
 * @date 2020-04-10
 */
@Service
public class RotationChartService {

    @Resource
    private RotationChartDao rotationChartDao;

    /**
     * RotationChartInfo 新增轮播图
     * @param rotationChartInfo
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addRotationChart(RotationChartInfo rotationChartInfo){
        //检验序号是否大于0
        int sort = rotationChartInfo.getSort();
        if(0 >= sort){
            return AppResponse.bizError("排序必须大于0！");
        }
        //检验已绑定轮播图的商品或序号是否存在
        int countGoodsCode = rotationChartDao.countGoodsCode(rotationChartInfo);
        if(0 != countGoodsCode){
            return AppResponse.bizError("此商品的轮播图已存在或序号已存在，请重新输入！");
        }
        //新增轮播图
        rotationChartInfo.setChartId(StringUtil.getCommonCode(2));
        int count = rotationChartDao.addRotationChart(rotationChartInfo);
        if(0 == count){
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * RotationChartInfo 查询轮播图商品列表
     * @param rotationGoodsVo
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    public AppResponse listRotationGoods(RotationGoodsVo rotationGoodsVo){
        PageHelper.startPage(rotationGoodsVo.getPageNum(),rotationGoodsVo.getPageSize());
        List<RotationGoodsVo> rgList = rotationChartDao.listRotationGoods(rotationGoodsVo);
        PageInfo<RotationGoodsVo> pageData = new PageInfo<>(rgList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * RotationChartInfo 删除轮播图
     * @param chartId
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteRotationChart(String chartId,String userId){
        List<String> listCode = Arrays.asList(chartId.split(","));
        int count = rotationChartDao.deleteRotationChart(listCode,userId);
        if(0 == count){
            return AppResponse.versionError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * RotationChartInfo 查询轮播图状态
     * @param rotationChartInfo
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    public AppResponse listRotationChartState(RotationChartInfo rotationChartInfo){
        PageHelper.startPage(rotationChartInfo.getPageNum(),rotationChartInfo.getPageSize());
        List<RotationChartInfo> rcList = rotationChartDao.listRotationChartState(rotationChartInfo);
        PageInfo<RotationChartInfo> pageData = new PageInfo<>(rcList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * RotationChartInfo 轮播图状态修改
     * @param chartId
     * @param chartState
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateRotationChartState(String chartId,String chartState,String userId){
        List<String> listCode = Arrays.asList(chartId.split(","));
        int count = rotationChartDao.updateRotationChartState(listCode,chartState,userId);
        if(0 == count){
            return AppResponse.versionError("轮播图状态修改失败，请重试！");
        }
        return AppResponse.success("轮播图状态修改成功！");
    }

}
