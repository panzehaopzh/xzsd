package com.xzsd.app.clientGoods.entity;

import java.util.List;

public class TwoClassifyInfo {
    /**
     * 二级商品分类编号
     */
    private String classifyId;
    /**
     * 二级商品分类名称
     */
    private String classifyName;
    /**
     * 此分类的商品信息集合
     */
    private List<GoodsVo> goodsList;

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public List<GoodsVo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsVo> goodsList) {
        this.goodsList = goodsList;
    }
}
