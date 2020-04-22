package com.xzsd.app.clientGoods.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientGoods.dao.ClientGoodsDao;
import com.xzsd.app.clientGoods.entity.GoodsInfo;
import com.xzsd.app.clientGoods.entity.OneClassifyInfo;
import com.xzsd.app.clientGoods.entity.TwoClassifyInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName ClientGoodsService
 * @Description 客户端商品模块
 * @author panzehao
 * @date 2020-04-22
 */
@Service
public class ClientGoodsService {

    @Resource
    private ClientGoodsDao clientGoodsDao;

    /**
     * clientGoods 查询商品信息详情
     * @param goodsCode
     * @return
     * @author panzehao
     * @date 2020-04-22
     */
    public AppResponse getGoods(String goodsCode){
        GoodsInfo goodsInfo = clientGoodsDao.getGoods(goodsCode);
        return AppResponse.success("查询成功！",goodsInfo);
    }

    /**
     * clientGoods 查询一级商品分类列
     * @param
     * @return
     * @author panzehao
     * @date 2020-04-22
     */
    public AppResponse listOneGoodsClassify(){
        List<OneClassifyInfo> oneClassifyInfoList = clientGoodsDao.listOneGoodsClassify();
        return AppResponse.success("查询成功！",oneClassifyInfoList);
    }

    /**
     * clientGoods 查询二级商品分类以及商品
     * @param classifyId
     * @return
     * @author panzehao
     * @date 2020-04-22
     */
    public AppResponse listGetClassGoods(String classifyId){
        List<TwoClassifyInfo> twoClassifyInfoList = clientGoodsDao.listGetClassGoods(classifyId);
        return AppResponse.success("查询成功！",twoClassifyInfoList);
    }
}
