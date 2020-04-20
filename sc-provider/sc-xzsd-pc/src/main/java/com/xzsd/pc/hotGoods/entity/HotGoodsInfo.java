package com.xzsd.pc.hotGoods.entity;

public class HotGoodsInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 热门位编号
     */
    private String hotId;
    /**
     * 热门位排序
     */
    private int hotSort;
    /**
     * 商品编号
     */
    private String goodsCode;
    /**
     * 商品名称
     */
    private String goodsName;
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
