package com.xzsd.pc.rotationChart.entity;

public class RotationChartInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 轮播图id
     */
    private String chartId;
    /**
     * 轮播图序号
     */
    private int sort;
    /**
     * 轮播图片地址
     */
    private String chartImage;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 有效期起
     */
    private String termValidityBegin;
    /**
     * 有效期止
     */
    private String termValidityEnd;
    /**
     * 轮播图状态 0启用 1禁用
     */
    private int chartState;
    /**
     * 删除标记 0未删 1已删
     */
    private String isDelete;
    /**
     * 创建者
     */
    private String createId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新者
     */
    private String updateId;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 版本号
     */
    private String version;

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

    public String getChartId() {
        return chartId;
    }

    public void setChartId(String chartId) {
        this.chartId = chartId;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getChartImage() {
        return chartImage;
    }

    public void setChartImage(String chartImage) {
        this.chartImage = chartImage;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getTermValidityBegin() {
        return termValidityBegin;
    }

    public void setTermValidityBegin(String termValidityBegin) {
        this.termValidityBegin = termValidityBegin;
    }

    public String getTermValidityEnd() {
        return termValidityEnd;
    }

    public void setTermValidityEnd(String termValidityEnd) {
        this.termValidityEnd = termValidityEnd;
    }

    public int getChartState() {
        return chartState;
    }

    public void setChartState(int chartState) {
        this.chartState = chartState;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
