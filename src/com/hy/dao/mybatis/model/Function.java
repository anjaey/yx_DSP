package com.hy.dao.mybatis.model;

public class Function {
    private Integer id;

    private String functionNameen;

    private Integer navid;

    private Integer state;

    private Integer rank;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFunctionNameen() {
        return functionNameen;
    }

    public void setFunctionNameen(String functionNameen) {
        this.functionNameen = functionNameen == null ? null : functionNameen.trim();
    }

    public Integer getNavid() {
        return navid;
    }

    public void setNavid(Integer navid) {
        this.navid = navid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}