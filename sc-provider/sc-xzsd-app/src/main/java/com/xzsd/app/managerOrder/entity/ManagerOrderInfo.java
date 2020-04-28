package com.xzsd.app.managerOrder.entity;

import java.util.List;

public class ManagerOrderInfo {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 订单状态
     */
    private String orderStateId;
    /**
     * 订单里商品信息集合
     */
    private List<OrderGoodsInfo> goodsList;
    /**
     * 客户编号
     */
    private String userId;
    /**
     * 客户姓名
     */
    private String userName;
    /**
     * 客户电话
     */
    private String phone;
    /**
     * 订单总价
     */
    private String orderAllCost;
    /**
     * 订单商品总数量
     */
    private int orderAllGoodsCount;
    /**
     * 版本号
     */
    private String version;

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

    public List<OrderGoodsInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoodsInfo> goodsList) {
        this.goodsList = goodsList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getOrderAllCost() {
        return orderAllCost;
    }

    public void setOrderAllCost(String orderAllCost) {
        this.orderAllCost = orderAllCost;
    }

    public int getOrderAllGoodsCount() {
        return orderAllGoodsCount;
    }

    public void setOrderAllGoodsCount(int orderAllGoodsCount) {
        this.orderAllGoodsCount = orderAllGoodsCount;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
