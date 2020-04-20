package com.xzsd.pc.topOfColumn.entity;

public class TopOfColumnInfo {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户头像图片路径
     */
    private String imagePath;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 角色 0管理员 1店长 2司机 3用户
     */
    private int role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
