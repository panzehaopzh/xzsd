package com.xzsd.pc.goodsSort.entity;

public class SecondSort {
    /**
     * 二级分类编码
     */
    private String secondSortId;
    /**
     * 二级分类名称
     */
    private String secondSortName;
    /**
     * 版本号
     */
    private String version;

    public String getSecondSortId() {
        return secondSortId;
    }

    public void setSecondSortId(String secondSortId) {
        this.secondSortId = secondSortId;
    }

    public String getSecondSortName() {
        return secondSortName;
    }

    public void setSecondSortName(String secondSortName) {
        this.secondSortName = secondSortName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
