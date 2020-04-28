package com.xzsd.pc.goodsSort.entity;

public class GoodsSortVo {
    /**
     * 分类编码
     */
    private String sortId;
    /**
     * 分类名称
     */
    private String sortName;
    /**
     * 父级编码
     */
    private String parentCode;
    /**
     * 备注
     */
    private String sortRemark;
    /**
     * 版本号
     */
    private String version;

    public String getSortId() {
        return sortId;
    }

    public void setSortId(String sortId) {
        this.sortId = sortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getSortRemark() {
        return sortRemark;
    }

    public void setSortRemark(String sortRemark) {
        this.sortRemark = sortRemark;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
