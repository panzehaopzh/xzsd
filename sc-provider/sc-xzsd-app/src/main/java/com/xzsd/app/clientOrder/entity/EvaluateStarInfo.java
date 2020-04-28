package com.xzsd.app.clientOrder.entity;

public class EvaluateStarInfo {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品评价星级
     */
    private String evaluateStar;
    /**
     * 订单商品购买数量
     */
    private int goodsCount;
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

    public String getEvaluateStar() {
        return evaluateStar;
    }

    public void setEvaluateStar(String evaluateStar) {
        this.evaluateStar = evaluateStar;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
