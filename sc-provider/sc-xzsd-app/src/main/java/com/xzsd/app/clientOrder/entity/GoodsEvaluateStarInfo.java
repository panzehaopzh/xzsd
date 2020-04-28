package com.xzsd.app.clientOrder.entity;

public class GoodsEvaluateStarInfo {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品星级
     */
    private String goodsStar;
    /**
     * 商品数量
     */
    private String goodsNum;
    /**
     * 用户id
     */
    private String userId;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsStar() {
        return goodsStar;
    }

    public void setGoodsStar(String goodsStar) {
        this.goodsStar = goodsStar;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
