package com.hy.dao.mybatis.model;

public class AlignmentStages {
    private Integer id;

    private String name;

    private Integer type;

    private String companyName;

    private String idcard;

    private Integer addressCity;

    private Integer addressArea;

    private String addressDetail;

    private String url;

    private Integer createUser;

    private Long createTime;

    private String aptitudesFile;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public Integer getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(Integer addressCity) {
        this.addressCity = addressCity;
    }

    public Integer getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(Integer addressArea) {
        this.addressArea = addressArea;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
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

    public String getAptitudesFile() {
        return aptitudesFile;
    }

    public void setAptitudesFile(String aptitudesFile) {
        this.aptitudesFile = aptitudesFile == null ? null : aptitudesFile.trim();
    }
}