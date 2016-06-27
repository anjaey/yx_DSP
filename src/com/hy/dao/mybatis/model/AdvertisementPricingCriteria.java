package com.hy.dao.mybatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AdvertisementPricingCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public AdvertisementPricingCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimitStart(Integer limitStart) {
        this.limitStart=limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd=limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andChargeWayIsNull() {
            addCriterion("charge_way is null");
            return (Criteria) this;
        }

        public Criteria andChargeWayIsNotNull() {
            addCriterion("charge_way is not null");
            return (Criteria) this;
        }

        public Criteria andChargeWayEqualTo(Integer value) {
            addCriterion("charge_way =", value, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andChargeWayNotEqualTo(Integer value) {
            addCriterion("charge_way <>", value, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andChargeWayGreaterThan(Integer value) {
            addCriterion("charge_way >", value, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andChargeWayGreaterThanOrEqualTo(Integer value) {
            addCriterion("charge_way >=", value, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andChargeWayLessThan(Integer value) {
            addCriterion("charge_way <", value, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andChargeWayLessThanOrEqualTo(Integer value) {
            addCriterion("charge_way <=", value, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andChargeWayIn(List<Integer> values) {
            addCriterion("charge_way in", values, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andChargeWayNotIn(List<Integer> values) {
            addCriterion("charge_way not in", values, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andChargeWayBetween(Integer value1, Integer value2) {
            addCriterion("charge_way between", value1, value2, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andChargeWayNotBetween(Integer value1, Integer value2) {
            addCriterion("charge_way not between", value1, value2, "chargeWay");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidIsNull() {
            addCriterion("\"check_ best _bid\" is null");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidIsNotNull() {
            addCriterion("\"check_ best _bid\" is not null");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidEqualTo(BigDecimal value) {
            addCriterion("\"check_ best _bid\" =", value, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidNotEqualTo(BigDecimal value) {
            addCriterion("\"check_ best _bid\" <>", value, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidGreaterThan(BigDecimal value) {
            addCriterion("\"check_ best _bid\" >", value, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("\"check_ best _bid\" >=", value, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidLessThan(BigDecimal value) {
            addCriterion("\"check_ best _bid\" <", value, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("\"check_ best _bid\" <=", value, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidIn(List<BigDecimal> values) {
            addCriterion("\"check_ best _bid\" in", values, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidNotIn(List<BigDecimal> values) {
            addCriterion("\"check_ best _bid\" not in", values, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("\"check_ best _bid\" between", value1, value2, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andCheckBestBidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("\"check_ best _bid\" not between", value1, value2, "checkBestBid");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaIsNull() {
            addCriterion("day_expenditure_quota is null");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaIsNotNull() {
            addCriterion("day_expenditure_quota is not null");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaEqualTo(BigDecimal value) {
            addCriterion("day_expenditure_quota =", value, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaNotEqualTo(BigDecimal value) {
            addCriterion("day_expenditure_quota <>", value, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaGreaterThan(BigDecimal value) {
            addCriterion("day_expenditure_quota >", value, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("day_expenditure_quota >=", value, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaLessThan(BigDecimal value) {
            addCriterion("day_expenditure_quota <", value, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("day_expenditure_quota <=", value, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaIn(List<BigDecimal> values) {
            addCriterion("day_expenditure_quota in", values, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaNotIn(List<BigDecimal> values) {
            addCriterion("day_expenditure_quota not in", values, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_expenditure_quota between", value1, value2, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andDayExpenditureQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("day_expenditure_quota not between", value1, value2, "dayExpenditureQuota");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitIsNull() {
            addCriterion("exposure_frequency_unit is null");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitIsNotNull() {
            addCriterion("exposure_frequency_unit is not null");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitEqualTo(Integer value) {
            addCriterion("exposure_frequency_unit =", value, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitNotEqualTo(Integer value) {
            addCriterion("exposure_frequency_unit <>", value, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitGreaterThan(Integer value) {
            addCriterion("exposure_frequency_unit >", value, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("exposure_frequency_unit >=", value, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitLessThan(Integer value) {
            addCriterion("exposure_frequency_unit <", value, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitLessThanOrEqualTo(Integer value) {
            addCriterion("exposure_frequency_unit <=", value, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitIn(List<Integer> values) {
            addCriterion("exposure_frequency_unit in", values, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitNotIn(List<Integer> values) {
            addCriterion("exposure_frequency_unit not in", values, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitBetween(Integer value1, Integer value2) {
            addCriterion("exposure_frequency_unit between", value1, value2, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("exposure_frequency_unit not between", value1, value2, "exposureFrequencyUnit");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoIsNull() {
            addCriterion("exposure_frequency_no is null");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoIsNotNull() {
            addCriterion("exposure_frequency_no is not null");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoEqualTo(Integer value) {
            addCriterion("exposure_frequency_no =", value, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoNotEqualTo(Integer value) {
            addCriterion("exposure_frequency_no <>", value, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoGreaterThan(Integer value) {
            addCriterion("exposure_frequency_no >", value, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("exposure_frequency_no >=", value, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoLessThan(Integer value) {
            addCriterion("exposure_frequency_no <", value, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoLessThanOrEqualTo(Integer value) {
            addCriterion("exposure_frequency_no <=", value, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoIn(List<Integer> values) {
            addCriterion("exposure_frequency_no in", values, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoNotIn(List<Integer> values) {
            addCriterion("exposure_frequency_no not in", values, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoBetween(Integer value1, Integer value2) {
            addCriterion("exposure_frequency_no between", value1, value2, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andExposureFrequencyNoNotBetween(Integer value1, Integer value2) {
            addCriterion("exposure_frequency_no not between", value1, value2, "exposureFrequencyNo");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitIsNull() {
            addCriterion("check_freque_unit is null");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitIsNotNull() {
            addCriterion("check_freque_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitEqualTo(Integer value) {
            addCriterion("check_freque_unit =", value, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitNotEqualTo(Integer value) {
            addCriterion("check_freque_unit <>", value, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitGreaterThan(Integer value) {
            addCriterion("check_freque_unit >", value, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_freque_unit >=", value, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitLessThan(Integer value) {
            addCriterion("check_freque_unit <", value, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitLessThanOrEqualTo(Integer value) {
            addCriterion("check_freque_unit <=", value, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitIn(List<Integer> values) {
            addCriterion("check_freque_unit in", values, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitNotIn(List<Integer> values) {
            addCriterion("check_freque_unit not in", values, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitBetween(Integer value1, Integer value2) {
            addCriterion("check_freque_unit between", value1, value2, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("check_freque_unit not between", value1, value2, "checkFrequeUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitIsNull() {
            addCriterion("check_freque_everyone_unit is null");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitIsNotNull() {
            addCriterion("check_freque_everyone_unit is not null");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitEqualTo(Integer value) {
            addCriterion("check_freque_everyone_unit =", value, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitNotEqualTo(Integer value) {
            addCriterion("check_freque_everyone_unit <>", value, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitGreaterThan(Integer value) {
            addCriterion("check_freque_everyone_unit >", value, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_freque_everyone_unit >=", value, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitLessThan(Integer value) {
            addCriterion("check_freque_everyone_unit <", value, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitLessThanOrEqualTo(Integer value) {
            addCriterion("check_freque_everyone_unit <=", value, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitIn(List<Integer> values) {
            addCriterion("check_freque_everyone_unit in", values, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitNotIn(List<Integer> values) {
            addCriterion("check_freque_everyone_unit not in", values, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitBetween(Integer value1, Integer value2) {
            addCriterion("check_freque_everyone_unit between", value1, value2, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andCheckFrequeEveryoneUnitNotBetween(Integer value1, Integer value2) {
            addCriterion("check_freque_everyone_unit not between", value1, value2, "checkFrequeEveryoneUnit");
            return (Criteria) this;
        }

        public Criteria andBasicIdIsNull() {
            addCriterion("basic_id is null");
            return (Criteria) this;
        }

        public Criteria andBasicIdIsNotNull() {
            addCriterion("basic_id is not null");
            return (Criteria) this;
        }

        public Criteria andBasicIdEqualTo(Integer value) {
            addCriterion("basic_id =", value, "basicId");
            return (Criteria) this;
        }

        public Criteria andBasicIdNotEqualTo(Integer value) {
            addCriterion("basic_id <>", value, "basicId");
            return (Criteria) this;
        }

        public Criteria andBasicIdGreaterThan(Integer value) {
            addCriterion("basic_id >", value, "basicId");
            return (Criteria) this;
        }

        public Criteria andBasicIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("basic_id >=", value, "basicId");
            return (Criteria) this;
        }

        public Criteria andBasicIdLessThan(Integer value) {
            addCriterion("basic_id <", value, "basicId");
            return (Criteria) this;
        }

        public Criteria andBasicIdLessThanOrEqualTo(Integer value) {
            addCriterion("basic_id <=", value, "basicId");
            return (Criteria) this;
        }

        public Criteria andBasicIdIn(List<Integer> values) {
            addCriterion("basic_id in", values, "basicId");
            return (Criteria) this;
        }

        public Criteria andBasicIdNotIn(List<Integer> values) {
            addCriterion("basic_id not in", values, "basicId");
            return (Criteria) this;
        }

        public Criteria andBasicIdBetween(Integer value1, Integer value2) {
            addCriterion("basic_id between", value1, value2, "basicId");
            return (Criteria) this;
        }

        public Criteria andBasicIdNotBetween(Integer value1, Integer value2) {
            addCriterion("basic_id not between", value1, value2, "basicId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}