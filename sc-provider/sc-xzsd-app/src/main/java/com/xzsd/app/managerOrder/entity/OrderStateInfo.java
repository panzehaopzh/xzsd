package com.xzsd.app.managerOrder.entity;

public class OrderStateInfo {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 版本号
     */
    private String version;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
