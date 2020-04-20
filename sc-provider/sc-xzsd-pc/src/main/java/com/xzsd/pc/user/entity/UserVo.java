package com.xzsd.pc.user.entity;

public class UserVo {
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 角色 0管理员 1店长 2司机 3客户
     */
    private String role;
    /**
     * 性别 1男 0女
     */
    private int sex;
    /**
     * 手机
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 身份证
     */
    private String idCard;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
