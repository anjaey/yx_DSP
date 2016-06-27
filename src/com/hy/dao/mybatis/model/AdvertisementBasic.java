package com.hy.dao.mybatis.model;

public class AdvertisementBasic {
    private Integer id;

    private String name;

    private String path;

    private String pvMonitoringAddress;

    private String tradeTag;

    private Integer createUser;

    private Long createTime;

    private Integer activityId;

    private Integer checkState;

    private String checkConclusion;

    private Integer popularizeType;

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getPvMonitoringAddress() {
        return pvMonitoringAddress;
    }

    public void setPvMonitoringAddress(String pvMonitoringAddress) {
        this.pvMonitoringAddress = pvMonitoringAddress == null ? null : pvMonitoringAddress.trim();
    }

    public String getTradeTag() {
        return tradeTag;
    }

    public void setTradeTag(String tradeTag) {
        this.tradeTag = tradeTag == null ? null : tradeTag.trim();
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getCheckState() {
        return checkState;
    }

    public void setCheckState(Integer checkState) {
        this.checkState = checkState;
    }

    public String getCheckConclusion() {
        return checkConclusion;
    }

    public void setCheckConclusion(String checkConclusion) {
        this.checkConclusion = checkConclusion == null ? null : checkConclusion.trim();
    }

    public Integer getPopularizeType() {
        return popularizeType;
    }

    public void setPopularizeType(Integer popularizeType) {
        this.popularizeType = popularizeType;
    }
}