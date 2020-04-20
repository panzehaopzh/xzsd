package com.xzsd.pc.order.entity;

public class OrderInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 订单编码
     */
    private String orderCode;
    /**
     * 订单状态 0已下单 1已到货 2已取货 3已完成未评价 4已完成已评价 5已取消
     */
    private String orderState;
    /**
     * 下单人姓名
     */
    private String userName;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 付款时间起
     */
    private String payTimeBegin;
    /**
     * 付款时间止
     */
    private String payTimeEnd;
    /**
     * 登录用户id
     */
    private String userId;
    /**
     * 角色 0管理员 1店长 2司机 3用户
     */
    private String role;
    /**
     * 删除标记 0未删 1已删
     */
    private String isDelete;
    /**
     * 创建者
     */
    private String createId;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新者
     */
    private String updateId;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 版本号
     */
    private String version;

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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
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

    public String getPayTimeBegin() {
        return payTimeBegin;
    }

    public void setPayTimeBegin(String payTimeBegin) {
        this.payTimeBegin = payTimeBegin;
    }

    public String getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(String payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateId() {
        return updateId;
    }

    public void setUpdateId(String updateId) {
        this.updateId = updateId;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
