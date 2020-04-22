package com.xzsd.app.userInformation.entity;

public class UserInfo {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userImage;
    /**
     * 角色 0管理员 1店长 2司机 3客户
     */
    private String role;
    /**
     * 门店编码
     */
    private String storeId;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 邀请码
     */
    private String inviteCode;
    /**
     * 地址
     */
    private String address;
    /**
     * 司机电话
     */
    private String phone;
    /**
     * 司机名称
     */
    private String driverName;
    /**
     * 版本号
     */
    private String version;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
