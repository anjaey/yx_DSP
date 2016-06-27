package com.hy.dao.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementCollimationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public AdvertisementCollimationCriteria() {
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

        public Criteria andRunTimeStateIsNull() {
            addCriterion("run_time_state is null");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateIsNotNull() {
            addCriterion("run_time_state is not null");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateEqualTo(Integer value) {
            addCriterion("run_time_state =", value, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateNotEqualTo(Integer value) {
            addCriterion("run_time_state <>", value, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateGreaterThan(Integer value) {
            addCriterion("run_time_state >", value, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("run_time_state >=", value, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateLessThan(Integer value) {
            addCriterion("run_time_state <", value, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateLessThanOrEqualTo(Integer value) {
            addCriterion("run_time_state <=", value, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateIn(List<Integer> values) {
            addCriterion("run_time_state in", values, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateNotIn(List<Integer> values) {
            addCriterion("run_time_state not in", values, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateBetween(Integer value1, Integer value2) {
            addCriterion("run_time_state between", value1, value2, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeStateNotBetween(Integer value1, Integer value2) {
            addCriterion("run_time_state not between", value1, value2, "runTimeState");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonIsNull() {
            addCriterion("run_time_value_json is null");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonIsNotNull() {
            addCriterion("run_time_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonEqualTo(String value) {
            addCriterion("run_time_value_json =", value, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonNotEqualTo(String value) {
            addCriterion("run_time_value_json <>", value, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonGreaterThan(String value) {
            addCriterion("run_time_value_json >", value, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("run_time_value_json >=", value, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonLessThan(String value) {
            addCriterion("run_time_value_json <", value, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonLessThanOrEqualTo(String value) {
            addCriterion("run_time_value_json <=", value, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonLike(String value) {
            addCriterion("run_time_value_json like", value, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonNotLike(String value) {
            addCriterion("run_time_value_json not like", value, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonIn(List<String> values) {
            addCriterion("run_time_value_json in", values, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonNotIn(List<String> values) {
            addCriterion("run_time_value_json not in", values, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonBetween(String value1, String value2) {
            addCriterion("run_time_value_json between", value1, value2, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andRunTimeValueJsonNotBetween(String value1, String value2) {
            addCriterion("run_time_value_json not between", value1, value2, "runTimeValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaStateIsNull() {
            addCriterion("area_state is null");
            return (Criteria) this;
        }

        public Criteria andAreaStateIsNotNull() {
            addCriterion("area_state is not null");
            return (Criteria) this;
        }

        public Criteria andAreaStateEqualTo(Integer value) {
            addCriterion("area_state =", value, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaStateNotEqualTo(Integer value) {
            addCriterion("area_state <>", value, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaStateGreaterThan(Integer value) {
            addCriterion("area_state >", value, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("area_state >=", value, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaStateLessThan(Integer value) {
            addCriterion("area_state <", value, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaStateLessThanOrEqualTo(Integer value) {
            addCriterion("area_state <=", value, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaStateIn(List<Integer> values) {
            addCriterion("area_state in", values, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaStateNotIn(List<Integer> values) {
            addCriterion("area_state not in", values, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaStateBetween(Integer value1, Integer value2) {
            addCriterion("area_state between", value1, value2, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaStateNotBetween(Integer value1, Integer value2) {
            addCriterion("area_state not between", value1, value2, "areaState");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonIsNull() {
            addCriterion("area_value_json is null");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonIsNotNull() {
            addCriterion("area_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonEqualTo(String value) {
            addCriterion("area_value_json =", value, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonNotEqualTo(String value) {
            addCriterion("area_value_json <>", value, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonGreaterThan(String value) {
            addCriterion("area_value_json >", value, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("area_value_json >=", value, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonLessThan(String value) {
            addCriterion("area_value_json <", value, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonLessThanOrEqualTo(String value) {
            addCriterion("area_value_json <=", value, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonLike(String value) {
            addCriterion("area_value_json like", value, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonNotLike(String value) {
            addCriterion("area_value_json not like", value, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonIn(List<String> values) {
            addCriterion("area_value_json in", values, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonNotIn(List<String> values) {
            addCriterion("area_value_json not in", values, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonBetween(String value1, String value2) {
            addCriterion("area_value_json between", value1, value2, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andAreaValueJsonNotBetween(String value1, String value2) {
            addCriterion("area_value_json not between", value1, value2, "areaValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxStateIsNull() {
            addCriterion("flux_state is null");
            return (Criteria) this;
        }

        public Criteria andFluxStateIsNotNull() {
            addCriterion("flux_state is not null");
            return (Criteria) this;
        }

        public Criteria andFluxStateEqualTo(String value) {
            addCriterion("flux_state =", value, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateNotEqualTo(String value) {
            addCriterion("flux_state <>", value, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateGreaterThan(String value) {
            addCriterion("flux_state >", value, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateGreaterThanOrEqualTo(String value) {
            addCriterion("flux_state >=", value, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateLessThan(String value) {
            addCriterion("flux_state <", value, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateLessThanOrEqualTo(String value) {
            addCriterion("flux_state <=", value, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateLike(String value) {
            addCriterion("flux_state like", value, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateNotLike(String value) {
            addCriterion("flux_state not like", value, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateIn(List<String> values) {
            addCriterion("flux_state in", values, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateNotIn(List<String> values) {
            addCriterion("flux_state not in", values, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateBetween(String value1, String value2) {
            addCriterion("flux_state between", value1, value2, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxStateNotBetween(String value1, String value2) {
            addCriterion("flux_state not between", value1, value2, "fluxState");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonIsNull() {
            addCriterion("flux_value_json is null");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonIsNotNull() {
            addCriterion("flux_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonEqualTo(String value) {
            addCriterion("flux_value_json =", value, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonNotEqualTo(String value) {
            addCriterion("flux_value_json <>", value, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonGreaterThan(String value) {
            addCriterion("flux_value_json >", value, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("flux_value_json >=", value, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonLessThan(String value) {
            addCriterion("flux_value_json <", value, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonLessThanOrEqualTo(String value) {
            addCriterion("flux_value_json <=", value, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonLike(String value) {
            addCriterion("flux_value_json like", value, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonNotLike(String value) {
            addCriterion("flux_value_json not like", value, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonIn(List<String> values) {
            addCriterion("flux_value_json in", values, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonNotIn(List<String> values) {
            addCriterion("flux_value_json not in", values, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonBetween(String value1, String value2) {
            addCriterion("flux_value_json between", value1, value2, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andFluxValueJsonNotBetween(String value1, String value2) {
            addCriterion("flux_value_json not between", value1, value2, "fluxValueJson");
            return (Criteria) this;
        }

        public Criteria andSexStateIsNull() {
            addCriterion("sex_state is null");
            return (Criteria) this;
        }

        public Criteria andSexStateIsNotNull() {
            addCriterion("sex_state is not null");
            return (Criteria) this;
        }

        public Criteria andSexStateEqualTo(String value) {
            addCriterion("sex_state =", value, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateNotEqualTo(String value) {
            addCriterion("sex_state <>", value, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateGreaterThan(String value) {
            addCriterion("sex_state >", value, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateGreaterThanOrEqualTo(String value) {
            addCriterion("sex_state >=", value, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateLessThan(String value) {
            addCriterion("sex_state <", value, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateLessThanOrEqualTo(String value) {
            addCriterion("sex_state <=", value, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateLike(String value) {
            addCriterion("sex_state like", value, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateNotLike(String value) {
            addCriterion("sex_state not like", value, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateIn(List<String> values) {
            addCriterion("sex_state in", values, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateNotIn(List<String> values) {
            addCriterion("sex_state not in", values, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateBetween(String value1, String value2) {
            addCriterion("sex_state between", value1, value2, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexStateNotBetween(String value1, String value2) {
            addCriterion("sex_state not between", value1, value2, "sexState");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonIsNull() {
            addCriterion("sex_value_json is null");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonIsNotNull() {
            addCriterion("sex_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonEqualTo(String value) {
            addCriterion("sex_value_json =", value, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonNotEqualTo(String value) {
            addCriterion("sex_value_json <>", value, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonGreaterThan(String value) {
            addCriterion("sex_value_json >", value, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("sex_value_json >=", value, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonLessThan(String value) {
            addCriterion("sex_value_json <", value, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonLessThanOrEqualTo(String value) {
            addCriterion("sex_value_json <=", value, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonLike(String value) {
            addCriterion("sex_value_json like", value, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonNotLike(String value) {
            addCriterion("sex_value_json not like", value, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonIn(List<String> values) {
            addCriterion("sex_value_json in", values, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonNotIn(List<String> values) {
            addCriterion("sex_value_json not in", values, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonBetween(String value1, String value2) {
            addCriterion("sex_value_json between", value1, value2, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andSexValueJsonNotBetween(String value1, String value2) {
            addCriterion("sex_value_json not between", value1, value2, "sexValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeStateIsNull() {
            addCriterion("age_state is null");
            return (Criteria) this;
        }

        public Criteria andAgeStateIsNotNull() {
            addCriterion("age_state is not null");
            return (Criteria) this;
        }

        public Criteria andAgeStateEqualTo(String value) {
            addCriterion("age_state =", value, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateNotEqualTo(String value) {
            addCriterion("age_state <>", value, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateGreaterThan(String value) {
            addCriterion("age_state >", value, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateGreaterThanOrEqualTo(String value) {
            addCriterion("age_state >=", value, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateLessThan(String value) {
            addCriterion("age_state <", value, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateLessThanOrEqualTo(String value) {
            addCriterion("age_state <=", value, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateLike(String value) {
            addCriterion("age_state like", value, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateNotLike(String value) {
            addCriterion("age_state not like", value, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateIn(List<String> values) {
            addCriterion("age_state in", values, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateNotIn(List<String> values) {
            addCriterion("age_state not in", values, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateBetween(String value1, String value2) {
            addCriterion("age_state between", value1, value2, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeStateNotBetween(String value1, String value2) {
            addCriterion("age_state not between", value1, value2, "ageState");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonIsNull() {
            addCriterion("age_value_json is null");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonIsNotNull() {
            addCriterion("age_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonEqualTo(String value) {
            addCriterion("age_value_json =", value, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonNotEqualTo(String value) {
            addCriterion("age_value_json <>", value, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonGreaterThan(String value) {
            addCriterion("age_value_json >", value, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("age_value_json >=", value, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonLessThan(String value) {
            addCriterion("age_value_json <", value, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonLessThanOrEqualTo(String value) {
            addCriterion("age_value_json <=", value, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonLike(String value) {
            addCriterion("age_value_json like", value, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonNotLike(String value) {
            addCriterion("age_value_json not like", value, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonIn(List<String> values) {
            addCriterion("age_value_json in", values, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonNotIn(List<String> values) {
            addCriterion("age_value_json not in", values, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonBetween(String value1, String value2) {
            addCriterion("age_value_json between", value1, value2, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andAgeValueJsonNotBetween(String value1, String value2) {
            addCriterion("age_value_json not between", value1, value2, "ageValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationStateIsNull() {
            addCriterion("constellation_state is null");
            return (Criteria) this;
        }

        public Criteria andConstellationStateIsNotNull() {
            addCriterion("constellation_state is not null");
            return (Criteria) this;
        }

        public Criteria andConstellationStateEqualTo(String value) {
            addCriterion("constellation_state =", value, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateNotEqualTo(String value) {
            addCriterion("constellation_state <>", value, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateGreaterThan(String value) {
            addCriterion("constellation_state >", value, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateGreaterThanOrEqualTo(String value) {
            addCriterion("constellation_state >=", value, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateLessThan(String value) {
            addCriterion("constellation_state <", value, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateLessThanOrEqualTo(String value) {
            addCriterion("constellation_state <=", value, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateLike(String value) {
            addCriterion("constellation_state like", value, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateNotLike(String value) {
            addCriterion("constellation_state not like", value, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateIn(List<String> values) {
            addCriterion("constellation_state in", values, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateNotIn(List<String> values) {
            addCriterion("constellation_state not in", values, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateBetween(String value1, String value2) {
            addCriterion("constellation_state between", value1, value2, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationStateNotBetween(String value1, String value2) {
            addCriterion("constellation_state not between", value1, value2, "constellationState");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonIsNull() {
            addCriterion("constellation_value_json is null");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonIsNotNull() {
            addCriterion("constellation_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonEqualTo(String value) {
            addCriterion("constellation_value_json =", value, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonNotEqualTo(String value) {
            addCriterion("constellation_value_json <>", value, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonGreaterThan(String value) {
            addCriterion("constellation_value_json >", value, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("constellation_value_json >=", value, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonLessThan(String value) {
            addCriterion("constellation_value_json <", value, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonLessThanOrEqualTo(String value) {
            addCriterion("constellation_value_json <=", value, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonLike(String value) {
            addCriterion("constellation_value_json like", value, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonNotLike(String value) {
            addCriterion("constellation_value_json not like", value, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonIn(List<String> values) {
            addCriterion("constellation_value_json in", values, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonNotIn(List<String> values) {
            addCriterion("constellation_value_json not in", values, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonBetween(String value1, String value2) {
            addCriterion("constellation_value_json between", value1, value2, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andConstellationValueJsonNotBetween(String value1, String value2) {
            addCriterion("constellation_value_json not between", value1, value2, "constellationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationStateIsNull() {
            addCriterion("education_state is null");
            return (Criteria) this;
        }

        public Criteria andEducationStateIsNotNull() {
            addCriterion("education_state is not null");
            return (Criteria) this;
        }

        public Criteria andEducationStateEqualTo(String value) {
            addCriterion("education_state =", value, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateNotEqualTo(String value) {
            addCriterion("education_state <>", value, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateGreaterThan(String value) {
            addCriterion("education_state >", value, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateGreaterThanOrEqualTo(String value) {
            addCriterion("education_state >=", value, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateLessThan(String value) {
            addCriterion("education_state <", value, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateLessThanOrEqualTo(String value) {
            addCriterion("education_state <=", value, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateLike(String value) {
            addCriterion("education_state like", value, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateNotLike(String value) {
            addCriterion("education_state not like", value, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateIn(List<String> values) {
            addCriterion("education_state in", values, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateNotIn(List<String> values) {
            addCriterion("education_state not in", values, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateBetween(String value1, String value2) {
            addCriterion("education_state between", value1, value2, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationStateNotBetween(String value1, String value2) {
            addCriterion("education_state not between", value1, value2, "educationState");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonIsNull() {
            addCriterion("education_value_json is null");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonIsNotNull() {
            addCriterion("education_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonEqualTo(String value) {
            addCriterion("education_value_json =", value, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonNotEqualTo(String value) {
            addCriterion("education_value_json <>", value, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonGreaterThan(String value) {
            addCriterion("education_value_json >", value, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("education_value_json >=", value, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonLessThan(String value) {
            addCriterion("education_value_json <", value, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonLessThanOrEqualTo(String value) {
            addCriterion("education_value_json <=", value, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonLike(String value) {
            addCriterion("education_value_json like", value, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonNotLike(String value) {
            addCriterion("education_value_json not like", value, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonIn(List<String> values) {
            addCriterion("education_value_json in", values, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonNotIn(List<String> values) {
            addCriterion("education_value_json not in", values, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonBetween(String value1, String value2) {
            addCriterion("education_value_json between", value1, value2, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEducationValueJsonNotBetween(String value1, String value2) {
            addCriterion("education_value_json not between", value1, value2, "educationValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningStateIsNull() {
            addCriterion("earning_state is null");
            return (Criteria) this;
        }

        public Criteria andEarningStateIsNotNull() {
            addCriterion("earning_state is not null");
            return (Criteria) this;
        }

        public Criteria andEarningStateEqualTo(String value) {
            addCriterion("earning_state =", value, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateNotEqualTo(String value) {
            addCriterion("earning_state <>", value, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateGreaterThan(String value) {
            addCriterion("earning_state >", value, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateGreaterThanOrEqualTo(String value) {
            addCriterion("earning_state >=", value, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateLessThan(String value) {
            addCriterion("earning_state <", value, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateLessThanOrEqualTo(String value) {
            addCriterion("earning_state <=", value, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateLike(String value) {
            addCriterion("earning_state like", value, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateNotLike(String value) {
            addCriterion("earning_state not like", value, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateIn(List<String> values) {
            addCriterion("earning_state in", values, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateNotIn(List<String> values) {
            addCriterion("earning_state not in", values, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateBetween(String value1, String value2) {
            addCriterion("earning_state between", value1, value2, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningStateNotBetween(String value1, String value2) {
            addCriterion("earning_state not between", value1, value2, "earningState");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonIsNull() {
            addCriterion("earning_value_json is null");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonIsNotNull() {
            addCriterion("earning_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonEqualTo(String value) {
            addCriterion("earning_value_json =", value, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonNotEqualTo(String value) {
            addCriterion("earning_value_json <>", value, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonGreaterThan(String value) {
            addCriterion("earning_value_json >", value, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("earning_value_json >=", value, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonLessThan(String value) {
            addCriterion("earning_value_json <", value, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonLessThanOrEqualTo(String value) {
            addCriterion("earning_value_json <=", value, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonLike(String value) {
            addCriterion("earning_value_json like", value, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonNotLike(String value) {
            addCriterion("earning_value_json not like", value, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonIn(List<String> values) {
            addCriterion("earning_value_json in", values, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonNotIn(List<String> values) {
            addCriterion("earning_value_json not in", values, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonBetween(String value1, String value2) {
            addCriterion("earning_value_json between", value1, value2, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEarningValueJsonNotBetween(String value1, String value2) {
            addCriterion("earning_value_json not between", value1, value2, "earningValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionStateIsNull() {
            addCriterion("emotion_state is null");
            return (Criteria) this;
        }

        public Criteria andEmotionStateIsNotNull() {
            addCriterion("emotion_state is not null");
            return (Criteria) this;
        }

        public Criteria andEmotionStateEqualTo(String value) {
            addCriterion("emotion_state =", value, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateNotEqualTo(String value) {
            addCriterion("emotion_state <>", value, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateGreaterThan(String value) {
            addCriterion("emotion_state >", value, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateGreaterThanOrEqualTo(String value) {
            addCriterion("emotion_state >=", value, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateLessThan(String value) {
            addCriterion("emotion_state <", value, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateLessThanOrEqualTo(String value) {
            addCriterion("emotion_state <=", value, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateLike(String value) {
            addCriterion("emotion_state like", value, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateNotLike(String value) {
            addCriterion("emotion_state not like", value, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateIn(List<String> values) {
            addCriterion("emotion_state in", values, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateNotIn(List<String> values) {
            addCriterion("emotion_state not in", values, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateBetween(String value1, String value2) {
            addCriterion("emotion_state between", value1, value2, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionStateNotBetween(String value1, String value2) {
            addCriterion("emotion_state not between", value1, value2, "emotionState");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonIsNull() {
            addCriterion("emotion_value_json is null");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonIsNotNull() {
            addCriterion("emotion_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonEqualTo(String value) {
            addCriterion("emotion_value_json =", value, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonNotEqualTo(String value) {
            addCriterion("emotion_value_json <>", value, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonGreaterThan(String value) {
            addCriterion("emotion_value_json >", value, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("emotion_value_json >=", value, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonLessThan(String value) {
            addCriterion("emotion_value_json <", value, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonLessThanOrEqualTo(String value) {
            addCriterion("emotion_value_json <=", value, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonLike(String value) {
            addCriterion("emotion_value_json like", value, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonNotLike(String value) {
            addCriterion("emotion_value_json not like", value, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonIn(List<String> values) {
            addCriterion("emotion_value_json in", values, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonNotIn(List<String> values) {
            addCriterion("emotion_value_json not in", values, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonBetween(String value1, String value2) {
            addCriterion("emotion_value_json between", value1, value2, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andEmotionValueJsonNotBetween(String value1, String value2) {
            addCriterion("emotion_value_json not between", value1, value2, "emotionValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestStateIsNull() {
            addCriterion("interest_state is null");
            return (Criteria) this;
        }

        public Criteria andInterestStateIsNotNull() {
            addCriterion("interest_state is not null");
            return (Criteria) this;
        }

        public Criteria andInterestStateEqualTo(String value) {
            addCriterion("interest_state =", value, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateNotEqualTo(String value) {
            addCriterion("interest_state <>", value, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateGreaterThan(String value) {
            addCriterion("interest_state >", value, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateGreaterThanOrEqualTo(String value) {
            addCriterion("interest_state >=", value, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateLessThan(String value) {
            addCriterion("interest_state <", value, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateLessThanOrEqualTo(String value) {
            addCriterion("interest_state <=", value, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateLike(String value) {
            addCriterion("interest_state like", value, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateNotLike(String value) {
            addCriterion("interest_state not like", value, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateIn(List<String> values) {
            addCriterion("interest_state in", values, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateNotIn(List<String> values) {
            addCriterion("interest_state not in", values, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateBetween(String value1, String value2) {
            addCriterion("interest_state between", value1, value2, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestStateNotBetween(String value1, String value2) {
            addCriterion("interest_state not between", value1, value2, "interestState");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonIsNull() {
            addCriterion("interest_value_json is null");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonIsNotNull() {
            addCriterion("interest_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonEqualTo(String value) {
            addCriterion("interest_value_json =", value, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonNotEqualTo(String value) {
            addCriterion("interest_value_json <>", value, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonGreaterThan(String value) {
            addCriterion("interest_value_json >", value, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("interest_value_json >=", value, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonLessThan(String value) {
            addCriterion("interest_value_json <", value, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonLessThanOrEqualTo(String value) {
            addCriterion("interest_value_json <=", value, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonLike(String value) {
            addCriterion("interest_value_json like", value, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonNotLike(String value) {
            addCriterion("interest_value_json not like", value, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonIn(List<String> values) {
            addCriterion("interest_value_json in", values, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonNotIn(List<String> values) {
            addCriterion("interest_value_json not in", values, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonBetween(String value1, String value2) {
            addCriterion("interest_value_json between", value1, value2, "interestValueJson");
            return (Criteria) this;
        }

        public Criteria andInterestValueJsonNotBetween(String value1, String value2) {
            addCriterion("interest_value_json not between", value1, value2, "interestValueJson");
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