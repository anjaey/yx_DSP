package com.hy.dao.mybatis.model;

public class FunctionRole {
    private Integer id;

    private Integer functionId;

    private Integer navid;

    private Integer roleid;

    private String functionNameen;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFunctionId() {
        return functionId;
    }

    public void setFunctionId(Integer functionId) {
        this.functionId = functionId;
    }

    public Integer getNavid() {
        return navid;
    }

    public void setNavid(Integer navid) {
        this.navid = navid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public String getFunctionNameen() {
        return functionNameen;
    }

    public void setFunctionNameen(String functionNameen) {
        this.functionNameen = functionNameen == null ? null : functionNameen.trim();
    }
}