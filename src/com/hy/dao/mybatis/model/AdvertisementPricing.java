package com.hy.dao.mybatis.model;

import java.math.BigDecimal;

public class AdvertisementPricing {
    private Integer id;

    private Integer chargeWay;

    private BigDecimal checkBestBidPrice;

    private BigDecimal dayExpenditureQuota;

    private Integer exposureFrequencyUnit;

    private Integer exposureFrequencyNo;

    private Integer checkFrequeUnit;

    private Integer checkFrequeEveryoneNo;

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

    public BigDecimal getCheckBestBidPrice() {
        return checkBestBidPrice;
    }

    public void setCheckBestBidPrice(BigDecimal checkBestBidPrice) {
        this.checkBestBidPrice = checkBestBidPrice;
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

    public Integer getCheckFrequeEveryoneNo() {
        return checkFrequeEveryoneNo;
    }

    public void setCheckFrequeEveryoneNo(Integer checkFrequeEveryoneNo) {
        this.checkFrequeEveryoneNo = checkFrequeEveryoneNo;
    }

    public Integer getBasicId() {
        return basicId;
    }

    public void setBasicId(Integer basicId) {
        this.basicId = basicId;
    }
}