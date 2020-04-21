package com.xzsd.pc.goodsSort.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goodsSort.dao.GoodsSortDao;
import com.xzsd.pc.goodsSort.entity.FirstSort;
import com.xzsd.pc.goodsSort.entity.GoodsSortInfo;

import com.xzsd.pc.goodsSort.entity.GoodsSortVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 实现类
 * panzehao
 * 2020-04-08
 */
@Service
public class GoodsSortService {

    @Resource
    private GoodsSortDao goodsSortDao;

    /**
     * goodsSort 新增商品分类
     * @param goodsSortInfo
     * @author panzehao
     * @date 2020-04-08
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsSort(GoodsSortInfo goodsSortInfo){
        String sortCode;
        if(null == goodsSortInfo.getParentCode()){
            sortCode = StringUtil.getCommonCode(2);
        }else{
            sortCode = StringUtil.getCommonCode(4);
        }
        goodsSortInfo.setSortId(sortCode);
        int count = goodsSortDao.addGoodsSort(goodsSortInfo);
        if(0 == count){
            return AppResponse.versionError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * goodsSort 修改商品分类
     * @param goodsSortInfo
     * @return
     * @author panzehao
     * @date 2020-04-08
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsSort(GoodsSortInfo goodsSortInfo){
        int count = goodsSortDao.updateGoodsSort(goodsSortInfo);
        if(0 == count){
            return AppResponse.versionError("修改失败，请重试！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * goodsSort 删除商品分类
     * @param sortId
     * @param userId
     * @return
     * @author panzehao
     * @date 2020-04-08
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsSort(String sortId,String userId){
        //查询商品分类是否有子分类
        int countSubcategory = goodsSortDao.countSubcategory(sortId);
        if(0 != countSubcategory){
            return AppResponse.bizError("所选商品分类已有子分类，无法删除，请重新选择！");
        }
        //查询商品分类是否有商品
        int countGoods = goodsSortDao.countGoods(sortId);
        if(0 != countGoods){
            return AppResponse.bizError("所选商品分类已有商品存在，无法删除，请重新选择！");
        }
        int count = goodsSortDao.deleteGoodsSort(sortId,userId);
        if(0 == count){
            return AppResponse.versionError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }

    /**
     * goodsSort 查询商品分类列表
     * @param
     * @return
     * @author panzehao
     * @date 2020-04-08
     */
    public AppResponse listGoodsSort(){
        List<FirstSort> firstSortList = goodsSortDao.listGoodsSort();
        return AppResponse.success("查询成功！",firstSortList);
    }

    /**
     * goodsSort 查询商品分类详情
     * @param sortId
     * @return
     * @author panzehao
     * @date 2020-04-08
     */
    public AppResponse getGoodsSort(String sortId){
        GoodsSortVo goodsSortVo = goodsSortDao.getGoodsSort(sortId);
        return AppResponse.success("查询成功！",goodsSortVo);
    }
}
