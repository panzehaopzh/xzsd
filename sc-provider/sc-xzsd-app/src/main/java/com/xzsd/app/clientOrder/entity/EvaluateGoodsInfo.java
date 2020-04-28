package com.xzsd.app.clientOrder.entity;

public class EvaluateGoodsInfo {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品图片路径
     */
    private String goodsImagePath;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }
}
