package com.xzsd.pc.menu.entity;

public class MenuVo {
    /**
     * 菜单编码
     */
    private String menuCode;
    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单路由
     */
    private String menuRoute;
    /**
     * 菜单备注
     */
    private String menuRemark;
    /**
     * 版本号
     */
    private String version;

    public String getMenuCode() {
        return menuCode;
    }

    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuRoute() {
        return menuRoute;
    }

    public void setMenuRoute(String menuRoute) {
        this.menuRoute = menuRoute;
    }

    public String getMenuRemark() {
        return menuRemark;
    }

    public void setMenuRemark(String menuRemark) {
        this.menuRemark = menuRemark;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
