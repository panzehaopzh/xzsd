package com.xzsd.app.clientOrder.entity;

public class EvaluateStarInfo {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品评价星级总数
     */
    private String evaluateStarCount;
    /**
     * 商品评价总数
     */
    private String evaluateGoodsCount;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getEvaluateStarCount() {
        return evaluateStarCount;
    }

    public void setEvaluateStarCount(String evaluateStarCount) {
        this.evaluateStarCount = evaluateStarCount;
    }

    public String getEvaluateGoodsCount() {
        return evaluateGoodsCount;
    }

    public void setEvaluateGoodsCount(String evaluateGoodsCount) {
        this.evaluateGoodsCount = evaluateGoodsCount;
    }
}
