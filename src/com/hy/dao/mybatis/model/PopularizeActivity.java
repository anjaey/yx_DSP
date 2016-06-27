package com.hy.dao.mybatis.model;

import java.math.BigDecimal;

public class PopularizeActivity {
    private Integer id;

    private String name;

    private Long startTime;

    private Long endTime;

    private Long createTime;

    private Integer createUser;

    private Integer state;

    private String activityId;

    private Integer popularizeTimeType;

    private BigDecimal everydayQuota;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public Integer getPopularizeTimeType() {
        return popularizeTimeType;
    }

    public void setPopularizeTimeType(Integer popularizeTimeType) {
        this.popularizeTimeType = popularizeTimeType;
    }

    public BigDecimal getEverydayQuota() {
        return everydayQuota;
    }

    public void setEverydayQuota(BigDecimal everydayQuota) {
        this.everydayQuota = everydayQuota;
    }
}