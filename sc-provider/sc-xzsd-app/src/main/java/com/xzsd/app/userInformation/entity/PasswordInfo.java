package com.xzsd.app.userInformation.entity;

public class PasswordInfo {
    /**
     * 用户编码
     */
    private String userCode;
    /**
     * 原密码
     */
    private String password;
    /**
     * 新密码
     */
    private String newPassword;
    /**
     * 确认密码
     */
    private String confirmPassword;
    /**
     * 版本号
     */
    private String version;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
