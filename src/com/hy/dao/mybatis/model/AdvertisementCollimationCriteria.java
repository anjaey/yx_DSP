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

        public Criteria andOperatingSystemValueJsonIsNull() {
            addCriterion("operating_system_value_json is null");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonIsNotNull() {
            addCriterion("operating_system_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonEqualTo(String value) {
            addCriterion("operating_system_value_json =", value, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonNotEqualTo(String value) {
            addCriterion("operating_system_value_json <>", value, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonGreaterThan(String value) {
            addCriterion("operating_system_value_json >", value, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("operating_system_value_json >=", value, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonLessThan(String value) {
            addCriterion("operating_system_value_json <", value, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonLessThanOrEqualTo(String value) {
            addCriterion("operating_system_value_json <=", value, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonLike(String value) {
            addCriterion("operating_system_value_json like", value, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonNotLike(String value) {
            addCriterion("operating_system_value_json not like", value, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonIn(List<String> values) {
            addCriterion("operating_system_value_json in", values, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonNotIn(List<String> values) {
            addCriterion("operating_system_value_json not in", values, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonBetween(String value1, String value2) {
            addCriterion("operating_system_value_json between", value1, value2, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatingSystemValueJsonNotBetween(String value1, String value2) {
            addCriterion("operating_system_value_json not between", value1, value2, "operatingSystemValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonIsNull() {
            addCriterion("network_environment_value_json is null");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonIsNotNull() {
            addCriterion("network_environment_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonEqualTo(String value) {
            addCriterion("network_environment_value_json =", value, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonNotEqualTo(String value) {
            addCriterion("network_environment_value_json <>", value, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonGreaterThan(String value) {
            addCriterion("network_environment_value_json >", value, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("network_environment_value_json >=", value, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonLessThan(String value) {
            addCriterion("network_environment_value_json <", value, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonLessThanOrEqualTo(String value) {
            addCriterion("network_environment_value_json <=", value, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonLike(String value) {
            addCriterion("network_environment_value_json like", value, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonNotLike(String value) {
            addCriterion("network_environment_value_json not like", value, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonIn(List<String> values) {
            addCriterion("network_environment_value_json in", values, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonNotIn(List<String> values) {
            addCriterion("network_environment_value_json not in", values, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonBetween(String value1, String value2) {
            addCriterion("network_environment_value_json between", value1, value2, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andNetworkEnvironmentValueJsonNotBetween(String value1, String value2) {
            addCriterion("network_environment_value_json not between", value1, value2, "networkEnvironmentValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonIsNull() {
            addCriterion("operator_value_json is null");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonIsNotNull() {
            addCriterion("operator_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonEqualTo(String value) {
            addCriterion("operator_value_json =", value, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonNotEqualTo(String value) {
            addCriterion("operator_value_json <>", value, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonGreaterThan(String value) {
            addCriterion("operator_value_json >", value, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("operator_value_json >=", value, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonLessThan(String value) {
            addCriterion("operator_value_json <", value, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonLessThanOrEqualTo(String value) {
            addCriterion("operator_value_json <=", value, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonLike(String value) {
            addCriterion("operator_value_json like", value, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonNotLike(String value) {
            addCriterion("operator_value_json not like", value, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonIn(List<String> values) {
            addCriterion("operator_value_json in", values, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonNotIn(List<String> values) {
            addCriterion("operator_value_json not in", values, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonBetween(String value1, String value2) {
            addCriterion("operator_value_json between", value1, value2, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andOperatorValueJsonNotBetween(String value1, String value2) {
            addCriterion("operator_value_json not between", value1, value2, "operatorValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonIsNull() {
            addCriterion("device_type_value_json is null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonIsNotNull() {
            addCriterion("device_type_value_json is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonEqualTo(String value) {
            addCriterion("device_type_value_json =", value, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonNotEqualTo(String value) {
            addCriterion("device_type_value_json <>", value, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonGreaterThan(String value) {
            addCriterion("device_type_value_json >", value, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonGreaterThanOrEqualTo(String value) {
            addCriterion("device_type_value_json >=", value, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonLessThan(String value) {
            addCriterion("device_type_value_json <", value, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonLessThanOrEqualTo(String value) {
            addCriterion("device_type_value_json <=", value, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonLike(String value) {
            addCriterion("device_type_value_json like", value, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonNotLike(String value) {
            addCriterion("device_type_value_json not like", value, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonIn(List<String> values) {
            addCriterion("device_type_value_json in", values, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonNotIn(List<String> values) {
            addCriterion("device_type_value_json not in", values, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonBetween(String value1, String value2) {
            addCriterion("device_type_value_json between", value1, value2, "deviceTypeValueJson");
            return (Criteria) this;
        }

        public Criteria andDeviceTypeValueJsonNotBetween(String value1, String value2) {
            addCriterion("device_type_value_json not between", value1, value2, "deviceTypeValueJson");
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