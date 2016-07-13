package com.hy.dao.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class CreativeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public CreativeCriteria() {
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

        public Criteria andCreativeIdIsNull() {
            addCriterion("creative_id is null");
            return (Criteria) this;
        }

        public Criteria andCreativeIdIsNotNull() {
            addCriterion("creative_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeIdEqualTo(String value) {
            addCriterion("creative_id =", value, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdNotEqualTo(String value) {
            addCriterion("creative_id <>", value, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdGreaterThan(String value) {
            addCriterion("creative_id >", value, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdGreaterThanOrEqualTo(String value) {
            addCriterion("creative_id >=", value, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdLessThan(String value) {
            addCriterion("creative_id <", value, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdLessThanOrEqualTo(String value) {
            addCriterion("creative_id <=", value, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdLike(String value) {
            addCriterion("creative_id like", value, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdNotLike(String value) {
            addCriterion("creative_id not like", value, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdIn(List<String> values) {
            addCriterion("creative_id in", values, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdNotIn(List<String> values) {
            addCriterion("creative_id not in", values, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdBetween(String value1, String value2) {
            addCriterion("creative_id between", value1, value2, "creativeId");
            return (Criteria) this;
        }

        public Criteria andCreativeIdNotBetween(String value1, String value2) {
            addCriterion("creative_id not between", value1, value2, "creativeId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdIsNull() {
            addCriterion("advertisement_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdIsNotNull() {
            addCriterion("advertisement_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdEqualTo(Integer value) {
            addCriterion("advertisement_id =", value, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdNotEqualTo(Integer value) {
            addCriterion("advertisement_id <>", value, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdGreaterThan(Integer value) {
            addCriterion("advertisement_id >", value, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advertisement_id >=", value, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdLessThan(Integer value) {
            addCriterion("advertisement_id <", value, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdLessThanOrEqualTo(Integer value) {
            addCriterion("advertisement_id <=", value, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdIn(List<Integer> values) {
            addCriterion("advertisement_id in", values, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdNotIn(List<Integer> values) {
            addCriterion("advertisement_id not in", values, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdBetween(Integer value1, Integer value2) {
            addCriterion("advertisement_id between", value1, value2, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andAdvertisementIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advertisement_id not between", value1, value2, "advertisementId");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeIsNull() {
            addCriterion("traffic_type is null");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeIsNotNull() {
            addCriterion("traffic_type is not null");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeEqualTo(Integer value) {
            addCriterion("traffic_type =", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotEqualTo(Integer value) {
            addCriterion("traffic_type <>", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeGreaterThan(Integer value) {
            addCriterion("traffic_type >", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("traffic_type >=", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeLessThan(Integer value) {
            addCriterion("traffic_type <", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeLessThanOrEqualTo(Integer value) {
            addCriterion("traffic_type <=", value, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeIn(List<Integer> values) {
            addCriterion("traffic_type in", values, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotIn(List<Integer> values) {
            addCriterion("traffic_type not in", values, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeBetween(Integer value1, Integer value2) {
            addCriterion("traffic_type between", value1, value2, "trafficType");
            return (Criteria) this;
        }

        public Criteria andTrafficTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("traffic_type not between", value1, value2, "trafficType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeIsNull() {
            addCriterion("creative_type is null");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeIsNotNull() {
            addCriterion("creative_type is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeEqualTo(Integer value) {
            addCriterion("creative_type =", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeNotEqualTo(Integer value) {
            addCriterion("creative_type <>", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeGreaterThan(Integer value) {
            addCriterion("creative_type >", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("creative_type >=", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeLessThan(Integer value) {
            addCriterion("creative_type <", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("creative_type <=", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeIn(List<Integer> values) {
            addCriterion("creative_type in", values, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeNotIn(List<Integer> values) {
            addCriterion("creative_type not in", values, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeBetween(Integer value1, Integer value2) {
            addCriterion("creative_type between", value1, value2, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("creative_type not between", value1, value2, "creativeType");
            return (Criteria) this;
        }

        public Criteria andTargetUrlIsNull() {
            addCriterion("target_url is null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlIsNotNull() {
            addCriterion("target_url is not null");
            return (Criteria) this;
        }

        public Criteria andTargetUrlEqualTo(String value) {
            addCriterion("target_url =", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotEqualTo(String value) {
            addCriterion("target_url <>", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlGreaterThan(String value) {
            addCriterion("target_url >", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlGreaterThanOrEqualTo(String value) {
            addCriterion("target_url >=", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlLessThan(String value) {
            addCriterion("target_url <", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlLessThanOrEqualTo(String value) {
            addCriterion("target_url <=", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlLike(String value) {
            addCriterion("target_url like", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotLike(String value) {
            addCriterion("target_url not like", value, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlIn(List<String> values) {
            addCriterion("target_url in", values, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotIn(List<String> values) {
            addCriterion("target_url not in", values, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlBetween(String value1, String value2) {
            addCriterion("target_url between", value1, value2, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andTargetUrlNotBetween(String value1, String value2) {
            addCriterion("target_url not between", value1, value2, "targetUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlIsNull() {
            addCriterion("click_url is null");
            return (Criteria) this;
        }

        public Criteria andClickUrlIsNotNull() {
            addCriterion("click_url is not null");
            return (Criteria) this;
        }

        public Criteria andClickUrlEqualTo(String value) {
            addCriterion("click_url =", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotEqualTo(String value) {
            addCriterion("click_url <>", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlGreaterThan(String value) {
            addCriterion("click_url >", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlGreaterThanOrEqualTo(String value) {
            addCriterion("click_url >=", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlLessThan(String value) {
            addCriterion("click_url <", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlLessThanOrEqualTo(String value) {
            addCriterion("click_url <=", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlLike(String value) {
            addCriterion("click_url like", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotLike(String value) {
            addCriterion("click_url not like", value, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlIn(List<String> values) {
            addCriterion("click_url in", values, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotIn(List<String> values) {
            addCriterion("click_url not in", values, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlBetween(String value1, String value2) {
            addCriterion("click_url between", value1, value2, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andClickUrlNotBetween(String value1, String value2) {
            addCriterion("click_url not between", value1, value2, "clickUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIsNull() {
            addCriterion("advert_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIsNotNull() {
            addCriterion("advert_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertIdEqualTo(Integer value) {
            addCriterion("advert_id =", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotEqualTo(Integer value) {
            addCriterion("advert_id <>", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdGreaterThan(Integer value) {
            addCriterion("advert_id >", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("advert_id >=", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdLessThan(Integer value) {
            addCriterion("advert_id <", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdLessThanOrEqualTo(Integer value) {
            addCriterion("advert_id <=", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIn(List<Integer> values) {
            addCriterion("advert_id in", values, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotIn(List<Integer> values) {
            addCriterion("advert_id not in", values, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdBetween(Integer value1, Integer value2) {
            addCriterion("advert_id between", value1, value2, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotBetween(Integer value1, Integer value2) {
            addCriterion("advert_id not between", value1, value2, "advertId");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlIsNull() {
            addCriterion("monitor_url is null");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlIsNotNull() {
            addCriterion("monitor_url is not null");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlEqualTo(String value) {
            addCriterion("monitor_url =", value, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlNotEqualTo(String value) {
            addCriterion("monitor_url <>", value, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlGreaterThan(String value) {
            addCriterion("monitor_url >", value, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlGreaterThanOrEqualTo(String value) {
            addCriterion("monitor_url >=", value, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlLessThan(String value) {
            addCriterion("monitor_url <", value, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlLessThanOrEqualTo(String value) {
            addCriterion("monitor_url <=", value, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlLike(String value) {
            addCriterion("monitor_url like", value, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlNotLike(String value) {
            addCriterion("monitor_url not like", value, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlIn(List<String> values) {
            addCriterion("monitor_url in", values, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlNotIn(List<String> values) {
            addCriterion("monitor_url not in", values, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlBetween(String value1, String value2) {
            addCriterion("monitor_url between", value1, value2, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andMonitorUrlNotBetween(String value1, String value2) {
            addCriterion("monitor_url not between", value1, value2, "monitorUrl");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Integer value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Integer value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Integer value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Integer value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Integer value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Integer> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Integer> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Integer value1, Integer value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(Integer value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(Integer value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(Integer value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(Integer value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(Integer value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<Integer> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<Integer> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(Integer value1, Integer value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(Integer value1, Integer value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressIsNull() {
            addCriterion("creative_address is null");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressIsNotNull() {
            addCriterion("creative_address is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressEqualTo(String value) {
            addCriterion("creative_address =", value, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressNotEqualTo(String value) {
            addCriterion("creative_address <>", value, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressGreaterThan(String value) {
            addCriterion("creative_address >", value, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressGreaterThanOrEqualTo(String value) {
            addCriterion("creative_address >=", value, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressLessThan(String value) {
            addCriterion("creative_address <", value, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressLessThanOrEqualTo(String value) {
            addCriterion("creative_address <=", value, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressLike(String value) {
            addCriterion("creative_address like", value, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressNotLike(String value) {
            addCriterion("creative_address not like", value, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressIn(List<String> values) {
            addCriterion("creative_address in", values, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressNotIn(List<String> values) {
            addCriterion("creative_address not in", values, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressBetween(String value1, String value2) {
            addCriterion("creative_address between", value1, value2, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeAddressNotBetween(String value1, String value2) {
            addCriterion("creative_address not between", value1, value2, "creativeAddress");
            return (Criteria) this;
        }

        public Criteria andCreativeNameIsNull() {
            addCriterion("creative_name is null");
            return (Criteria) this;
        }

        public Criteria andCreativeNameIsNotNull() {
            addCriterion("creative_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeNameEqualTo(String value) {
            addCriterion("creative_name =", value, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameNotEqualTo(String value) {
            addCriterion("creative_name <>", value, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameGreaterThan(String value) {
            addCriterion("creative_name >", value, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameGreaterThanOrEqualTo(String value) {
            addCriterion("creative_name >=", value, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameLessThan(String value) {
            addCriterion("creative_name <", value, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameLessThanOrEqualTo(String value) {
            addCriterion("creative_name <=", value, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameLike(String value) {
            addCriterion("creative_name like", value, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameNotLike(String value) {
            addCriterion("creative_name not like", value, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameIn(List<String> values) {
            addCriterion("creative_name in", values, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameNotIn(List<String> values) {
            addCriterion("creative_name not in", values, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameBetween(String value1, String value2) {
            addCriterion("creative_name between", value1, value2, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeNameNotBetween(String value1, String value2) {
            addCriterion("creative_name not between", value1, value2, "creativeName");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlIsNull() {
            addCriterion("creative_down_url is null");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlIsNotNull() {
            addCriterion("creative_down_url is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlEqualTo(String value) {
            addCriterion("creative_down_url =", value, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlNotEqualTo(String value) {
            addCriterion("creative_down_url <>", value, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlGreaterThan(String value) {
            addCriterion("creative_down_url >", value, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlGreaterThanOrEqualTo(String value) {
            addCriterion("creative_down_url >=", value, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlLessThan(String value) {
            addCriterion("creative_down_url <", value, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlLessThanOrEqualTo(String value) {
            addCriterion("creative_down_url <=", value, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlLike(String value) {
            addCriterion("creative_down_url like", value, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlNotLike(String value) {
            addCriterion("creative_down_url not like", value, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlIn(List<String> values) {
            addCriterion("creative_down_url in", values, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlNotIn(List<String> values) {
            addCriterion("creative_down_url not in", values, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlBetween(String value1, String value2) {
            addCriterion("creative_down_url between", value1, value2, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDownUrlNotBetween(String value1, String value2) {
            addCriterion("creative_down_url not between", value1, value2, "creativeDownUrl");
            return (Criteria) this;
        }

        public Criteria andCreativeDesIsNull() {
            addCriterion("creative_des is null");
            return (Criteria) this;
        }

        public Criteria andCreativeDesIsNotNull() {
            addCriterion("creative_des is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeDesEqualTo(String value) {
            addCriterion("creative_des =", value, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesNotEqualTo(String value) {
            addCriterion("creative_des <>", value, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesGreaterThan(String value) {
            addCriterion("creative_des >", value, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesGreaterThanOrEqualTo(String value) {
            addCriterion("creative_des >=", value, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesLessThan(String value) {
            addCriterion("creative_des <", value, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesLessThanOrEqualTo(String value) {
            addCriterion("creative_des <=", value, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesLike(String value) {
            addCriterion("creative_des like", value, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesNotLike(String value) {
            addCriterion("creative_des not like", value, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesIn(List<String> values) {
            addCriterion("creative_des in", values, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesNotIn(List<String> values) {
            addCriterion("creative_des not in", values, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesBetween(String value1, String value2) {
            addCriterion("creative_des between", value1, value2, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeDesNotBetween(String value1, String value2) {
            addCriterion("creative_des not between", value1, value2, "creativeDes");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeIsNull() {
            addCriterion("creative_app_size is null");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeIsNotNull() {
            addCriterion("creative_app_size is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeEqualTo(Float value) {
            addCriterion("creative_app_size =", value, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeNotEqualTo(Float value) {
            addCriterion("creative_app_size <>", value, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeGreaterThan(Float value) {
            addCriterion("creative_app_size >", value, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeGreaterThanOrEqualTo(Float value) {
            addCriterion("creative_app_size >=", value, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeLessThan(Float value) {
            addCriterion("creative_app_size <", value, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeLessThanOrEqualTo(Float value) {
            addCriterion("creative_app_size <=", value, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeIn(List<Float> values) {
            addCriterion("creative_app_size in", values, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeNotIn(List<Float> values) {
            addCriterion("creative_app_size not in", values, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeBetween(Float value1, Float value2) {
            addCriterion("creative_app_size between", value1, value2, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreativeAppSizeNotBetween(Float value1, Float value2) {
            addCriterion("creative_app_size not between", value1, value2, "creativeAppSize");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Long value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Long value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Long value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Long value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Long value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Long> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Long> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Long value1, Long value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Long value1, Long value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNull() {
            addCriterion("check_time is null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIsNotNull() {
            addCriterion("check_time is not null");
            return (Criteria) this;
        }

        public Criteria andCheckTimeEqualTo(Long value) {
            addCriterion("check_time =", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotEqualTo(Long value) {
            addCriterion("check_time <>", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThan(Long value) {
            addCriterion("check_time >", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("check_time >=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThan(Long value) {
            addCriterion("check_time <", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeLessThanOrEqualTo(Long value) {
            addCriterion("check_time <=", value, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeIn(List<Long> values) {
            addCriterion("check_time in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotIn(List<Long> values) {
            addCriterion("check_time not in", values, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeBetween(Long value1, Long value2) {
            addCriterion("check_time between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckTimeNotBetween(Long value1, Long value2) {
            addCriterion("check_time not between", value1, value2, "checkTime");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNull() {
            addCriterion("check_state is null");
            return (Criteria) this;
        }

        public Criteria andCheckStateIsNotNull() {
            addCriterion("check_state is not null");
            return (Criteria) this;
        }

        public Criteria andCheckStateEqualTo(Integer value) {
            addCriterion("check_state =", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotEqualTo(Integer value) {
            addCriterion("check_state <>", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThan(Integer value) {
            addCriterion("check_state >", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_state >=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThan(Integer value) {
            addCriterion("check_state <", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateLessThanOrEqualTo(Integer value) {
            addCriterion("check_state <=", value, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateIn(List<Integer> values) {
            addCriterion("check_state in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotIn(List<Integer> values) {
            addCriterion("check_state not in", values, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateBetween(Integer value1, Integer value2) {
            addCriterion("check_state between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckStateNotBetween(Integer value1, Integer value2) {
            addCriterion("check_state not between", value1, value2, "checkState");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionIsNull() {
            addCriterion("check_conclusion is null");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionIsNotNull() {
            addCriterion("check_conclusion is not null");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionEqualTo(String value) {
            addCriterion("check_conclusion =", value, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionNotEqualTo(String value) {
            addCriterion("check_conclusion <>", value, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionGreaterThan(String value) {
            addCriterion("check_conclusion >", value, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionGreaterThanOrEqualTo(String value) {
            addCriterion("check_conclusion >=", value, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionLessThan(String value) {
            addCriterion("check_conclusion <", value, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionLessThanOrEqualTo(String value) {
            addCriterion("check_conclusion <=", value, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionLike(String value) {
            addCriterion("check_conclusion like", value, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionNotLike(String value) {
            addCriterion("check_conclusion not like", value, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionIn(List<String> values) {
            addCriterion("check_conclusion in", values, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionNotIn(List<String> values) {
            addCriterion("check_conclusion not in", values, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionBetween(String value1, String value2) {
            addCriterion("check_conclusion between", value1, value2, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCheckConclusionNotBetween(String value1, String value2) {
            addCriterion("check_conclusion not between", value1, value2, "checkConclusion");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("create_user is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("create_user is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Integer value) {
            addCriterion("create_user =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Integer value) {
            addCriterion("create_user <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Integer value) {
            addCriterion("create_user >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_user >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Integer value) {
            addCriterion("create_user <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Integer value) {
            addCriterion("create_user <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Integer> values) {
            addCriterion("create_user in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Integer> values) {
            addCriterion("create_user not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Integer value1, Integer value2) {
            addCriterion("create_user between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Integer value1, Integer value2) {
            addCriterion("create_user not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeIsNull() {
            addCriterion("deduct_quantity_proportion_before is null");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeIsNotNull() {
            addCriterion("deduct_quantity_proportion_before is not null");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeEqualTo(Float value) {
            addCriterion("deduct_quantity_proportion_before =", value, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeNotEqualTo(Float value) {
            addCriterion("deduct_quantity_proportion_before <>", value, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeGreaterThan(Float value) {
            addCriterion("deduct_quantity_proportion_before >", value, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeGreaterThanOrEqualTo(Float value) {
            addCriterion("deduct_quantity_proportion_before >=", value, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeLessThan(Float value) {
            addCriterion("deduct_quantity_proportion_before <", value, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeLessThanOrEqualTo(Float value) {
            addCriterion("deduct_quantity_proportion_before <=", value, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeIn(List<Float> values) {
            addCriterion("deduct_quantity_proportion_before in", values, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeNotIn(List<Float> values) {
            addCriterion("deduct_quantity_proportion_before not in", values, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeBetween(Float value1, Float value2) {
            addCriterion("deduct_quantity_proportion_before between", value1, value2, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionBeforeNotBetween(Float value1, Float value2) {
            addCriterion("deduct_quantity_proportion_before not between", value1, value2, "deductQuantityProportionBefore");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridIsNull() {
            addCriterion("deduct_quantity_proportion_update_userid is null");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridIsNotNull() {
            addCriterion("deduct_quantity_proportion_update_userid is not null");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridEqualTo(Integer value) {
            addCriterion("deduct_quantity_proportion_update_userid =", value, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridNotEqualTo(Integer value) {
            addCriterion("deduct_quantity_proportion_update_userid <>", value, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridGreaterThan(Integer value) {
            addCriterion("deduct_quantity_proportion_update_userid >", value, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("deduct_quantity_proportion_update_userid >=", value, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridLessThan(Integer value) {
            addCriterion("deduct_quantity_proportion_update_userid <", value, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridLessThanOrEqualTo(Integer value) {
            addCriterion("deduct_quantity_proportion_update_userid <=", value, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridIn(List<Integer> values) {
            addCriterion("deduct_quantity_proportion_update_userid in", values, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridNotIn(List<Integer> values) {
            addCriterion("deduct_quantity_proportion_update_userid not in", values, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridBetween(Integer value1, Integer value2) {
            addCriterion("deduct_quantity_proportion_update_userid between", value1, value2, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateUseridNotBetween(Integer value1, Integer value2) {
            addCriterion("deduct_quantity_proportion_update_userid not between", value1, value2, "deductQuantityProportionUpdateUserid");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeIsNull() {
            addCriterion("deduct_quantity_proportion_update_time is null");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeIsNotNull() {
            addCriterion("deduct_quantity_proportion_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeEqualTo(Long value) {
            addCriterion("deduct_quantity_proportion_update_time =", value, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeNotEqualTo(Long value) {
            addCriterion("deduct_quantity_proportion_update_time <>", value, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeGreaterThan(Long value) {
            addCriterion("deduct_quantity_proportion_update_time >", value, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("deduct_quantity_proportion_update_time >=", value, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeLessThan(Long value) {
            addCriterion("deduct_quantity_proportion_update_time <", value, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeLessThanOrEqualTo(Long value) {
            addCriterion("deduct_quantity_proportion_update_time <=", value, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeIn(List<Long> values) {
            addCriterion("deduct_quantity_proportion_update_time in", values, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeNotIn(List<Long> values) {
            addCriterion("deduct_quantity_proportion_update_time not in", values, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeBetween(Long value1, Long value2) {
            addCriterion("deduct_quantity_proportion_update_time between", value1, value2, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionUpdateTimeNotBetween(Long value1, Long value2) {
            addCriterion("deduct_quantity_proportion_update_time not between", value1, value2, "deductQuantityProportionUpdateTime");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterIsNull() {
            addCriterion("deduct_quantity_proportion_later is null");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterIsNotNull() {
            addCriterion("deduct_quantity_proportion_later is not null");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterEqualTo(Float value) {
            addCriterion("deduct_quantity_proportion_later =", value, "deductQuantityProportionLater");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterNotEqualTo(Float value) {
            addCriterion("deduct_quantity_proportion_later <>", value, "deductQuantityProportionLater");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterGreaterThan(Float value) {
            addCriterion("deduct_quantity_proportion_later >", value, "deductQuantityProportionLater");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterGreaterThanOrEqualTo(Float value) {
            addCriterion("deduct_quantity_proportion_later >=", value, "deductQuantityProportionLater");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterLessThan(Float value) {
            addCriterion("deduct_quantity_proportion_later <", value, "deductQuantityProportionLater");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterLessThanOrEqualTo(Float value) {
            addCriterion("deduct_quantity_proportion_later <=", value, "deductQuantityProportionLater");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterIn(List<Float> values) {
            addCriterion("deduct_quantity_proportion_later in", values, "deductQuantityProportionLater");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterNotIn(List<Float> values) {
            addCriterion("deduct_quantity_proportion_later not in", values, "deductQuantityProportionLater");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterBetween(Float value1, Float value2) {
            addCriterion("deduct_quantity_proportion_later between", value1, value2, "deductQuantityProportionLater");
            return (Criteria) this;
        }

        public Criteria andDeductQuantityProportionLaterNotBetween(Float value1, Float value2) {
            addCriterion("deduct_quantity_proportion_later not between", value1, value2, "deductQuantityProportionLater");
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