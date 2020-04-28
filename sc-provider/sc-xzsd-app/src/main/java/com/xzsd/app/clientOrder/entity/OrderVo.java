package com.xzsd.app.clientOrder.entity;

public class OrderVo {
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 订单状态编号 0已下单，1已到货，2已取货，3已完成未评价，4已完成已评价，5已取消
     */
    private String orderStateId;
    /**
     * 一页多少条记录
     */
    private int pageSize;
    /**
     * 页码
     */
    private int pageNum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderStateId() {
        return orderStateId;
    }

    public void setOrderStateId(String orderStateId) {
        this.orderStateId = orderStateId;
    }

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
}
