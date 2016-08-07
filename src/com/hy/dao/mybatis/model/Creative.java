package com.hy.dao.mybatis.model;

public class Creative {
    private Integer id;

    private String creativeId;

    private Integer advertisementId;

    private String creativeType;

    private Long createTime;

    private Long checkTime;

    private Integer checkState;

    private String checkConclusion;

    private Integer createUser;

    private Float deductQuantityProportionBefore;

    private Integer deductQuantityProportionUpdateUserid;

    private Long deductQuantityProportionUpdateTime;

    private Float deductQuantityProportionLater;

    private Integer state;

    private String creativeModality;

    private String size;

    private String path;

    private Integer processState;

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

    public String getCreativeType() {
        return creativeType;
    }

    public void setCreativeType(String creativeType) {
        this.creativeType = creativeType == null ? null : creativeType.trim();
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

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Float getDeductQuantityProportionBefore() {
        return deductQuantityProportionBefore;
    }

    public void setDeductQuantityProportionBefore(Float deductQuantityProportionBefore) {
        this.deductQuantityProportionBefore = deductQuantityProportionBefore;
    }

    public Integer getDeductQuantityProportionUpdateUserid() {
        return deductQuantityProportionUpdateUserid;
    }

    public void setDeductQuantityProportionUpdateUserid(Integer deductQuantityProportionUpdateUserid) {
        this.deductQuantityProportionUpdateUserid = deductQuantityProportionUpdateUserid;
    }

    public Long getDeductQuantityProportionUpdateTime() {
        return deductQuantityProportionUpdateTime;
    }

    public void setDeductQuantityProportionUpdateTime(Long deductQuantityProportionUpdateTime) {
        this.deductQuantityProportionUpdateTime = deductQuantityProportionUpdateTime;
    }

    public Float getDeductQuantityProportionLater() {
        return deductQuantityProportionLater;
    }

    public void setDeductQuantityProportionLater(Float deductQuantityProportionLater) {
        this.deductQuantityProportionLater = deductQuantityProportionLater;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreativeModality() {
        return creativeModality;
    }

    public void setCreativeModality(String creativeModality) {
        this.creativeModality = creativeModality == null ? null : creativeModality.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public Integer getProcessState() {
        return processState;
    }

    public void setProcessState(Integer processState) {
        this.processState = processState;
    }
}