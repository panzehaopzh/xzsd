package com.xzsd.app.managerOrder.entity;

import java.util.List;

public class OrderDetailInfo {
    /**
     * 订单编号
     */
    private String orderId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 订单状态编号 0已下单，1已到货，2已取货，3已完成未评价，4已完成已评价，5已取消
     */
    private String orderStateId;
    /**
     * 客户姓名
     */
    private String userName;
    /**
     * 客户电话
     */
    private String phone;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 详细地址
     */
    private String address;
    /**
     * 订单商品信息集合
     */
    private List<OrderGoodsInfo> goodsList;
    /**
     * 订单总价
     */
    private String orderAllCost;
    /**
     * 订单商品总数量
     */
    private int orderAllGoodsCount;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
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

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderGoodsInfo> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<OrderGoodsInfo> goodsList) {
        this.goodsList = goodsList;
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
}
