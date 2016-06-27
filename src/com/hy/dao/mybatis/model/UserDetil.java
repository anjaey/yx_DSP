package com.hy.dao.mybatis.model;

public class UserDetil extends UserDetilKey {
    private String compellation;

    private String qq;

    private String wechat;

    private String mobilephone;

    private String epithet;

    private String ico;

    private String connectionEmial;

    public String getCompellation() {
        return compellation;
    }

    public void setCompellation(String compellation) {
        this.compellation = compellation == null ? null : compellation.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone == null ? null : mobilephone.trim();
    }

    public String getEpithet() {
        return epithet;
    }

    public void setEpithet(String epithet) {
        this.epithet = epithet == null ? null : epithet.trim();
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico == null ? null : ico.trim();
    }

    public String getConnectionEmial() {
        return connectionEmial;
    }

    public void setConnectionEmial(String connectionEmial) {
        this.connectionEmial = connectionEmial == null ? null : connectionEmial.trim();
    }
}