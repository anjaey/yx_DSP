package com.hy.dao.mybatis.model;

public class Creative {
    private Integer id;

    private String creativeId;

    private Integer advertisementId;

    private Integer trafficType;

    private Integer creativeType;

    private String targetUrl;

    private String clickUrl;

    private Integer advertId;

    private String monitorUrl;

    private Integer height;

    private Integer weight;

    private String creativeAddress;

    private String creativeName;

    private String creativeDownUrl;

    private String creativeDes;

    private Float creativeAppSize;

    private Long createTime;

    private Long checkTime;

    private Integer checkState;

    private String checkConclusion;

    private Integer createId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreativeId() {
        return creativeId;
    }

    public void setCreativeId(String creativeId) {
        this.creativeId = creativeId == null ? null : creativeId.trim();
    }

    public Integer getAdvertisementId() {
        return advertisementId;
    }

    public void setAdvertisementId(Integer advertisementId) {
        this.advertisementId = advertisementId;
    }

    public Integer getTrafficType() {
        return trafficType;
    }

    public void setTrafficType(Integer trafficType) {
        this.trafficType = trafficType;
    }

    public Integer getCreativeType() {
        return creativeType;
    }

    public void setCreativeType(Integer creativeType) {
        this.creativeType = creativeType;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl == null ? null : targetUrl.trim();
    }

    public String getClickUrl() {
        return clickUrl;
    }

    public void setClickUrl(String clickUrl) {
        this.clickUrl = clickUrl == null ? null : clickUrl.trim();
    }

    public Integer getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Integer advertId) {
        this.advertId = advertId;
    }

    public String getMonitorUrl() {
        return monitorUrl;
    }

    public void setMonitorUrl(String monitorUrl) {
        this.monitorUrl = monitorUrl == null ? null : monitorUrl.trim();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getCreativeAddress() {
        return creativeAddress;
    }

    public void setCreativeAddress(String creativeAddress) {
        this.creativeAddress = creativeAddress == null ? null : creativeAddress.trim();
    }

    public String getCreativeName() {
        return creativeName;
    }

    public void setCreativeName(String creativeName) {
        this.creativeName = creativeName == null ? null : creativeName.trim();
    }

    public String getCreativeDownUrl() {
        return creativeDownUrl;
    }

    public void setCreativeDownUrl(String creativeDownUrl) {
        this.creativeDownUrl = creativeDownUrl == null ? null : creativeDownUrl.trim();
    }

    public String getCreativeDes() {
        return creativeDes;
    }

    public void setCreativeDes(String creativeDes) {
        this.creativeDes = creativeDes == null ? null : creativeDes.trim();
    }

    public Float getCreativeAppSize() {
        return creativeAppSize;
    }

    public void setCreativeAppSize(Float creativeAppSize) {
        this.creativeAppSize = creativeAppSize;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Long checkTime) {
        this.checkTime = checkTime;
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

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
    }
}