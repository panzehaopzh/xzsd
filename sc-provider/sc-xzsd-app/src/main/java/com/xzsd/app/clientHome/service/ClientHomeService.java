package com.xzsd.app.clientHome.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientHome.dao.ClientHomeDao;
import com.xzsd.app.clientHome.entity.HotGoodsInfo;
import com.xzsd.app.clientHome.entity.SlideshowInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ClientHomeService
 * @Description 客户端首页
 * @author panzehao
 * @date 2020-04-22
 */
@Service
public class ClientHomeService {

    @Resource
    private ClientHomeDao clientHomeDao;

    /**
     * clientHome 查询首页轮播图
     * @param
     * @return
     * @author panzehao
     * @date 2020-04-22
     */
    public AppResponse listRotationChartHome(){
        List<SlideshowInfo> slideshowInfoList = clientHomeDao.listRotationChartHome();
        return AppResponse.success("查询成功！",slideshowInfoList);
    }

    /**
     * clientHome 查询首页热门商品
     * @param
     * @return
     * @author panzehao
     * @date 2020-04-22
     */
    public AppResponse listHotGoods(){
        int hotGoodsNum = clientHomeDao.getHotGoodsNum();
        List<HotGoodsInfo> hotGoodsInfoList = clientHomeDao.listHotGoods(hotGoodsNum);
        return AppResponse.success("查询成功！",hotGoodsInfoList);
    }
}
