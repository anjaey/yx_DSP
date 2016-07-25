package com.hy.dao.mybatis.model;

public class AdvertisementCollimation {
    private Integer id;

    private Integer basicId;

    private String areaValueJson;

    private String sexValueJson;

    private String ageValueJson;

    private String interestValueJson;

    private String operatingSystemValueJson;

    private String networkEnvironmentValueJson;

    private String operatorValueJson;

    private String deviceTypeValueJson;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBasicId() {
        return basicId;
    }

    public void setBasicId(Integer basicId) {
        this.basicId = basicId;
    }

    public String getAreaValueJson() {
        return areaValueJson;
    }

    public void setAreaValueJson(String areaValueJson) {
        this.areaValueJson = areaValueJson == null ? null : areaValueJson.trim();
    }

    public String getSexValueJson() {
        return sexValueJson;
    }

    public void setSexValueJson(String sexValueJson) {
        this.sexValueJson = sexValueJson == null ? null : sexValueJson.trim();
    }

    public String getAgeValueJson() {
        return ageValueJson;
    }

    public void setAgeValueJson(String ageValueJson) {
        this.ageValueJson = ageValueJson == null ? null : ageValueJson.trim();
    }

    public String getInterestValueJson() {
        return interestValueJson;
    }

    public void setInterestValueJson(String interestValueJson) {
        this.interestValueJson = interestValueJson == null ? null : interestValueJson.trim();
    }

    public String getOperatingSystemValueJson() {
        return operatingSystemValueJson;
    }

    public void setOperatingSystemValueJson(String operatingSystemValueJson) {
        this.operatingSystemValueJson = operatingSystemValueJson == null ? null : operatingSystemValueJson.trim();
    }

    public String getNetworkEnvironmentValueJson() {
        return networkEnvironmentValueJson;
    }

    public void setNetworkEnvironmentValueJson(String networkEnvironmentValueJson) {
        this.networkEnvironmentValueJson = networkEnvironmentValueJson == null ? null : networkEnvironmentValueJson.trim();
    }

    public String getOperatorValueJson() {
        return operatorValueJson;
    }

    public void setOperatorValueJson(String operatorValueJson) {
        this.operatorValueJson = operatorValueJson == null ? null : operatorValueJson.trim();
    }

    public String getDeviceTypeValueJson() {
        return deviceTypeValueJson;
    }

    public void setDeviceTypeValueJson(String deviceTypeValueJson) {
        this.deviceTypeValueJson = deviceTypeValueJson == null ? null : deviceTypeValueJson.trim();
    }
}