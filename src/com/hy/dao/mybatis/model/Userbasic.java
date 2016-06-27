package com.hy.dao.mybatis.model;

public class Userbasic {
    private Integer id;

    private String username;

    private String pwd;

    private Long createtime;

    private Integer createuser;

    private Integer isdelete;

    private Integer type;

    private String email;

    private Long emailSpSendTime;

    private String getPwdCode;

    private Long getPwdOuttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }

    public Integer getCreateuser() {
        return createuser;
    }

    public void setCreateuser(Integer createuser) {
        this.createuser = createuser;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Long getEmailSpSendTime() {
        return emailSpSendTime;
    }

    public void setEmailSpSendTime(Long emailSpSendTime) {
        this.emailSpSendTime = emailSpSendTime;
    }

    public String getGetPwdCode() {
        return getPwdCode;
    }

    public void setGetPwdCode(String getPwdCode) {
        this.getPwdCode = getPwdCode == null ? null : getPwdCode.trim();
    }

    public Long getGetPwdOuttime() {
        return getPwdOuttime;
    }

    public void setGetPwdOuttime(Long getPwdOuttime) {
        this.getPwdOuttime = getPwdOuttime;
    }
}