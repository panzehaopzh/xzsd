package com.xzsd.pc.hotGoods.entity;

public class HotGoodsVo {
    /**
     * 热门位编号
     */
    private String hotId;
    /**
     * 热门位排序
     */
    private int hotSort;
    /**
     * 商品编码
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 在售价
     */
    private double sellingPrice;
    /**
     * 商品介绍
     */
    private String introduce;

    public String getHotId() {
        return hotId;
    }

    public void setHotId(String hotId) {
        this.hotId = hotId;
    }

    public int getHotSort() {
        return hotSort;
    }

    public void setHotSort(int hotSort) {
        this.hotSort = hotSort;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
