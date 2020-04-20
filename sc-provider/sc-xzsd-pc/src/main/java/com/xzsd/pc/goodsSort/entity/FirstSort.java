package com.xzsd.pc.goodsSort.entity;

import java.util.List;

public class FirstSort {
    /**
     * 一级分类编码
     */
    private String firstSortId;
    /**
     * 一级分类名称
     */
    private String firstSortName;
    /**
     * 版本号
     */
    private String version;
    /**
     * 二级分类列表
     */
    private List<SecondSort> secondSortList;

    public String getFirstSortId() {
        return firstSortId;
    }

    public void setFirstSortId(String firstSortId) {
        this.firstSortId = firstSortId;
    }

    public String getFirstSortName() {
        return firstSortName;
    }

    public void setFirstSortName(String firstSortName) {
        this.firstSortName = firstSortName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<SecondSort> getSecondSortList() {
        return secondSortList;
    }

    public void setSecondSortList(List<SecondSort> secondSortList) {
        this.secondSortList = secondSortList;
    }
}
