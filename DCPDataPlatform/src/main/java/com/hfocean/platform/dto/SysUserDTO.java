package com.hfocean.platform.dto;

import java.io.Serializable;

public class SysUserDTO implements Serializable {

    private static final long serialVersionUID = 215669299641730431L;

    private Long userId;

    private String loginName;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    @Override
    public String toString() {
        return "SysUserDTO{" +
                "userId=" + userId +
                ", loginName=" + loginName +
                '}';
    }
}
