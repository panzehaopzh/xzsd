package com.xzsd.app.clientOrder.entity;

import java.util.List;

public class EvaluateInfo {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 商品评价信息集合
     */
    private List<GoodsEvaluateInfo> evaluateList;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<GoodsEvaluateInfo> getEvaluateList() {
        return evaluateList;
    }

    public void setEvaluateList(List<GoodsEvaluateInfo> evaluateList) {
        this.evaluateList = evaluateList;
    }
}
