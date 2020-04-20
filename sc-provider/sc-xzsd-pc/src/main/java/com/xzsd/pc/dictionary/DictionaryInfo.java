package com.xzsd.pc.dictionary;

public class DictionaryInfo {
    /**
     * 字段编码
     */
    private String dictionaryCode;
    /**
     * 字段名称
     */
    private String dictionaryName;
    /**
     * 父级编码
     */
    private String parentCode;

    public String getDictionaryCode() {
        return dictionaryCode;
    }

    public void setDictionaryCode(String dictionaryCode) {
        this.dictionaryCode = dictionaryCode;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }
}
