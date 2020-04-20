package com.xzsd.pc.driver.entity;

public class DriverVo {
    /**
     * 司机编号
     */
    private String driverCode;
    /**
     * 司机姓名
     */
    private String driverName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 司机账号
     */
    private String driverAccount;

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDriverAccount() {
        return driverAccount;
    }

    public void setDriverAccount(String driverAccount) {
        this.driverAccount = driverAccount;
    }
}
