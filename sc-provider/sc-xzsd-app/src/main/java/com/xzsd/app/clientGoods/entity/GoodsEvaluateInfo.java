package com.xzsd.app.clientGoods.entity;

public class GoodsEvaluateInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 评价编号
     */
    private String evaluateCode;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 用户账号
     */
    private String userAcct;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价星级 0-5表示0-5颗星
     */
    private int evaluateScore;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
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

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
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
