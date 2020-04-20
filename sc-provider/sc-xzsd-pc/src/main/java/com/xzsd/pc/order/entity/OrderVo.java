package com.xzsd.pc.order.entity;

public class OrderVo {
    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 订单总价
     */
    private String orderAmount;
    /**
     * 订单状态 0已下单 1已到货 2已取货 3已完成未评价 4已完成已评价 5已取消
     */
    private String orderState;
    /**
     * 门店编码
     */
    private String storeId;
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 下单人姓名
     */
    private String userName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 下单时间
     */
    private String orderTime;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(String orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }
}
