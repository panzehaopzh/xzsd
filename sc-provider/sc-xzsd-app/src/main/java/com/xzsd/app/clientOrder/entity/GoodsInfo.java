package com.xzsd.app.clientOrder.entity;

public class GoodsInfo {
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品库存
     */
    private int goodsStock;
    /**
     * 更新人
     */
    private String updateId;

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public int getGoodsStock() {
        return goodsStock;
    }

    public void setGoodsStock(int goodsStock) {
        this.goodsStock = goodsStock;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }
}
