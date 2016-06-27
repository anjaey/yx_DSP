package com.hy.dao.mybatis.model;

import java.math.BigDecimal;

public class AdvertisementPricing {
    private Integer id;

    private Integer chargeWay;

    private BigDecimal checkBestBid;

    private BigDecimal dayExpenditureQuota;

    private Integer exposureFrequencyUnit;

    private Integer exposureFrequencyNo;

    private Integer checkFrequeUnit;

    private Integer checkFrequeEveryoneUnit;

    private Integer basicId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChargeWay() {
        return chargeWay;
    }

    public void setChargeWay(Integer chargeWay) {
        this.chargeWay = chargeWay;
    }

    public BigDecimal getCheckBestBid() {
        return checkBestBid;
    }

    public void setCheckBestBid(BigDecimal checkBestBid) {
        this.checkBestBid = checkBestBid;
    }

    public BigDecimal getDayExpenditureQuota() {
        return dayExpenditureQuota;
    }

    public void setDayExpenditureQuota(BigDecimal dayExpenditureQuota) {
        this.dayExpenditureQuota = dayExpenditureQuota;
    }

    public Integer getExposureFrequencyUnit() {
        return exposureFrequencyUnit;
    }

    public void setExposureFrequencyUnit(Integer exposureFrequencyUnit) {
        this.exposureFrequencyUnit = exposureFrequencyUnit;
    }

    public Integer getExposureFrequencyNo() {
        return exposureFrequencyNo;
    }

    public void setExposureFrequencyNo(Integer exposureFrequencyNo) {
        this.exposureFrequencyNo = exposureFrequencyNo;
    }

    public Integer getCheckFrequeUnit() {
        return checkFrequeUnit;
    }

    public void setCheckFrequeUnit(Integer checkFrequeUnit) {
        this.checkFrequeUnit = checkFrequeUnit;
    }

    public Integer getCheckFrequeEveryoneUnit() {
        return checkFrequeEveryoneUnit;
    }

    public void setCheckFrequeEveryoneUnit(Integer checkFrequeEveryoneUnit) {
        this.checkFrequeEveryoneUnit = checkFrequeEveryoneUnit;
    }

    public Integer getBasicId() {
        return basicId;
    }

    public void setBasicId(Integer basicId) {
        this.basicId = basicId;
    }
}