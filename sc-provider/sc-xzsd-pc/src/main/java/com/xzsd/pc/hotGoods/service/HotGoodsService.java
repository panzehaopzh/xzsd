package com.xzsd.pc.hotGoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.hotGoods.dao.HotGoodsDao;
import com.xzsd.pc.hotGoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotGoods.entity.HotGoodsVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName HotGoodsService
 * @Description 热门位商品管理
 * @author panzehao
 * @date 2020-04-11
 */
@Service
public class HotGoodsService {

    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * hotGoods 新增热门位商品
     * @param hotGoodsInfo
     * @return
     * @author panzehao
     * @date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        //检验热门位商品序号是否大于0
        int sort = hotGoodsInfo.getHotSort();
        if(0 >= sort){
            return AppResponse.bizError("排序必须大于0！");
        }
        //检验热门位商品和热门位序号是否存在
        int countHotGoods = hotGoodsDao.countHotGoods(hotGoodsInfo);
        if(0 != countHotGoods){
            return AppResponse.bizError("该热门位商品已存在或该热门位序号已存在，请重新输入！");
        }
        hotGoodsInfo.setHotId(StringUtil.getCommonCode(2));
        //新增热门位商品
        int count = hotGoodsDao.addHotGoods(hotGoodsInfo);
        if(0 == count){
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * hotGoods 修改热门位商品
     * @param hotGoodsInfo
     * @return
     * @author panzehao
     * @date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo){
        int sort = hotGoodsInfo.getHotSort();
        if(0 >= sort){
            return AppResponse.bizError("排序必须大于0！");
        }
        //检验热门位商品和热门位序号是否存在
        int countHotGoods = hotGoodsDao.countHotGoods(hotGoodsInfo);
        if(0 != countHotGoods){
            return AppResponse.bizError("该热门位商品已存在或该热门位序号已存在，请重新输入！");
        }
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if(0 == count){
            return AppResponse.versionError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * hotGoods 删除热门位商品
     * @param hotId
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotId,String userId){
        List<String> listCode = Arrays.asList(hotId.split(","));
        //删除热门位商品
        int count = hotGoodsDao.deleteHotGoods(listCode,userId);
        if(0 == count){
            return AppResponse.versionError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * hotGoods 查询热门位商品详情
     * @param hotId
     * @return
     * @author panzehao
     * @date 2020-04-11
     */
    public AppResponse getHotGoods(String hotId){
        HotGoodsInfo hotGoodsInfo = hotGoodsDao.getHotGoods(hotId);
        return AppResponse.success("查询成功！",hotGoodsInfo);
    }

    /**
     * hotGoods 查询热门位商品列表
     * @param hotGoodsInfo
     * @return
     * @author panzehao
     * @date 2020-04-11
     */
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo){
        PageHelper.startPage(hotGoodsInfo.getPageNum(),hotGoodsInfo.getPageSize());
        List<HotGoodsVo> hotGoodsVoList = hotGoodsDao.listHotGoodsByPage(hotGoodsInfo);
        //包装Page对象
        PageInfo<HotGoodsVo> pageDate = new PageInfo<>(hotGoodsVoList);
        return AppResponse.success("查询成功！",pageDate);
    }

    /**
     * hotGoods 查询展示数量
     * @param
     * @return
     * @author panzehao
     * @date 2020-04-11
     */
    public AppResponse getHotGoodsNum(){
        int hotGoodsNum = hotGoodsDao.getHotGoodsNum();
        return AppResponse.success("查询成功！",hotGoodsNum);
    }

    /**
     * hotGoods 修改展示数量
     * @param hotGoodsNum
     * @return
     * @author panzehao
     * @date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoodsNum(int hotGoodsNum){
        int count = hotGoodsDao.updateHotGoodsNum(hotGoodsNum);
        if(0 == count){
            return AppResponse.versionError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }
}
