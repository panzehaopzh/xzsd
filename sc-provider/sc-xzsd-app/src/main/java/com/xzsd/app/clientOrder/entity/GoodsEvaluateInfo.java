package com.xzsd.app.clientOrder.entity;

public class GoodsEvaluateInfo {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 评价编号
     */
    private String evaluateCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 商品等级
     */
    private int evaluateScore;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getEvaluateCode() {
        return evaluateCode;
    }

    public void setEvaluateCode(String evaluateCode) {
        this.evaluateCode = evaluateCode;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }
}
