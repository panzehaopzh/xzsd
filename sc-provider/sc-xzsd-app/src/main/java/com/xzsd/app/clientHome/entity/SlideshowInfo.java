package com.xzsd.app.clientHome.entity;

public class SlideshowInfo {
    /**
     * 轮播图片路径
     */
    private String slideshowPath;
    /**
     * 商品编号
     */
    private String goodsCode;

    public String getSlideshowPath() {
        return slideshowPath;
    }

    public void setSlideshowPath(String slideshowPath) {
        this.slideshowPath = slideshowPath;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
}
