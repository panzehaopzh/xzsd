package com.xzsd.pc.goods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.SortInfo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 实现类
 * panzehao
 * 2020-03-30
 */
@Service
public class GoodsService {

    @Resource
    private GoodsDao goodsDao;

    /**
     * goods 新增商品
     * @param goodsInfo
     * @return
     * @author panzehao
     * @date 2020-03-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodsInfo goodsInfo){
        //检验书号是否存在
        int countISBM = goodsDao.countISBM(goodsInfo);
        if (0 != countISBM){
            return AppResponse.bizError("书号已存在，请重新输入！");
        }
        goodsInfo.setGoodsCode(StringUtil.getCommonCode(3));
        //新增商品
        int count = goodsDao.addGoods(goodsInfo);
        if (0 == count) {
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * goods 删除商品
     * @param goodsCode
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-03-30
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsCode,String userId){
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        //获取在轮播图和热门商品的商品
        List<String> goodsCodeList = goodsDao.listHotChart(listCode);
        //去除选中的商品编号中在轮播图和热门商品的商品
        ArrayList listGoodsCode = new ArrayList<String>(listCode);
        listGoodsCode.removeAll(goodsCodeList);
        //查询选中的商品编号中在轮播图和热门商品的商品名称
        List<String> goodsNameList = goodsDao.listGoodsName(goodsCodeList);
        if(listGoodsCode.size() == 0){
            return AppResponse.bizError("删除失败，商品" + goodsNameList +"都处于轮播图或热门商品上，无法删除！");
        }
        //删除商品
        int count = goodsDao.deleteGoods(listGoodsCode,userId);
        if (0 == count){
            return AppResponse.bizError("删除失败，请重试！");
        }
        if(goodsCodeList.size() != 0 && listGoodsCode.size() != 0){;
            return AppResponse.success("部分商品删除成功，商品" + goodsNameList + "正处于轮播图或热门商品上，无法删除！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * goods 修改商品
     * @param goodsInfo
     * @return
     * @author panzehao
     * @date 2020-03-30
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo){
        //检验书号是否存在
        int countISBM = goodsDao.countISBM(goodsInfo);
        if(0 != countISBM){
            return AppResponse.bizError("书号已存在，请重新输入！");
        }
        //修改商品信息
        int count = goodsDao.updateGoods(goodsInfo);
        if(0 == count){
            return AppResponse.versionError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * goods 查询商品详情
     * @param goodsCode
     * @return
     * @author panzehao
     * @date 2020-03-30
     */
    public AppResponse getGoods(String goodsCode){
        GoodsInfo goodsInfo = goodsDao.getGoods(goodsCode);
        return AppResponse.success("查询成功！",goodsInfo);
    }

    /**
     * goods 查询商品列表（分页）
     * @param goodsInfo
     * @return
     * @author panzehao
     * @date 2020-03-30
     */
    public AppResponse listGoods(GoodsInfo goodsInfo){
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = goodsDao.listGoods(goodsInfo);
        //包装Page对象
        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodsInfoList);
        return AppResponse.success("查询成功！", pageData);
    }

    /**
     * goods 商品上架下架修改
     * @param goodsCode
     * @param goodsState
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-03-30
     */
    @Transactional(rollbackFor =  Exception.class)
    public AppResponse updateGoodsState(String goodsCode,String goodsState,String userId){
        List<String> listCode = Arrays.asList(goodsCode.split(","));
        int count = goodsDao.updateGoodsState(listCode,goodsState,userId);
        if(0 == count){
            return AppResponse.versionError("商品状态修改失败，请重试！");
        }
        return AppResponse.success("商品状态修改成功！");
    }

    /**
     * goods 查询商品分类下拉框
     * @param sortId
     * @return
     * @author panzehao
     * @date 2020-04-08
     */
    public AppResponse listSort(String sortId){
        List<SortInfo> sortInfoList  = goodsDao.listSort(sortId);
        return AppResponse.success("查询成功",sortInfoList);
    }

}
