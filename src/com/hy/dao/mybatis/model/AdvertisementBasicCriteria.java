package com.hy.dao.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class AdvertisementBasicCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public AdvertisementBasicCriteria() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPathIsNull() {
            addCriterion("path is null");
            return (Criteria) this;
        }

        public Criteria andPathIsNotNull() {
            addCriterion("path is not null");
            return (Criteria) this;
        }

        public Criteria andPathEqualTo(String value) {
            addCriterion("path =", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotEqualTo(String value) {
            addCriterion("path <>", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThan(String value) {
            addCriterion("path >", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathGreaterThanOrEqualTo(String value) {
            addCriterion("path >=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThan(String value) {
            addCriterion("path <", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLessThanOrEqualTo(String value) {
            addCriterion("path <=", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathLike(String value) {
            addCriterion("path like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotLike(String value) {
            addCriterion("path not like", value, "path");
            return (Criteria) this;
        }

        public Criteria andPathIn(List<String> values) {
            addCriterion("path in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotIn(List<String> values) {
            addCriterion("path not in", values, "path");
            return (Criteria) this;
        }

        public Criteria andPathBetween(String value1, String value2) {
            addCriterion("path between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPathNotBetween(String value1, String value2) {
            addCriterion("path not between", value1, value2, "path");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressIsNull() {
            addCriterion("PV_monitoring_address is null");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressIsNotNull() {
            addCriterion("PV_monitoring_address is not null");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressEqualTo(String value) {
            addCriterion("PV_monitoring_address =", value, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressNotEqualTo(String value) {
            addCriterion("PV_monitoring_address <>", value, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressGreaterThan(String value) {
            addCriterion("PV_monitoring_address >", value, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressGreaterThanOrEqualTo(String value) {
            addCriterion("PV_monitoring_address >=", value, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressLessThan(String value) {
            addCriterion("PV_monitoring_address <", value, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressLessThanOrEqualTo(String value) {
            addCriterion("PV_monitoring_address <=", value, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressLike(String value) {
            addCriterion("PV_monitoring_address like", value, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressNotLike(String value) {
            addCriterion("PV_monitoring_address not like", value, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressIn(List<String> values) {
            addCriterion("PV_monitoring_address in", values, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressNotIn(List<String> values) {
            addCriterion("PV_monitoring_address not in", values, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressBetween(String value1, String value2) {
            addCriterion("PV_monitoring_address between", value1, value2, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andPvMonitoringAddressNotBetween(String value1, String value2) {
            addCriterion("PV_monitoring_address not between", value1, value2, "pvMonitoringAddress");
            return (Criteria) this;
        }

        public Criteria andTradeTagIsNull() {
            addCriterion("trade_tag is null");
            return (Criteria) this;
        }

        public Criteria andTradeTagIsNotNull() {
            addCriterion("trade_tag is not null");
            return (Criteria) this;
        }

        public Criteria andTradeTagEqualTo(String value) {
            addCriterion("trade_tag =", value, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagNotEqualTo(String value) {
            addCriterion("trade_tag <>", value, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagGreaterThan(String value) {
            addCriterion("trade_tag >", value, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagGreaterThanOrEqualTo(String value) {
            addCriterion("trade_tag >=", value, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagLessThan(String value) {
            addCriterion("trade_tag <", value, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagLessThanOrEqualTo(String value) {
            addCriterion("trade_tag <=", value, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagLike(String value) {
            addCriterion("trade_tag like", value, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagNotLike(String value) {
            addCriterion("trade_tag not like", value, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagIn(List<String> values) {
            addCriterion("trade_tag in", values, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagNotIn(List<String> values) {
            addCriterion("trade_tag not in", values, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagBetween(String value1, String value2) {
            addCriterion("trade_tag between", value1, value2, "tradeTag");
            return (Criteria) this;
        }

        public Criteria andTradeTagNotBetween(String value1, String value2) {
            addCriterion("trade_tag not between", value1, value2, "tradeTag");
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

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
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

        public Criteria andPopularizeTypeIsNull() {
            addCriterion("popularize_type is null");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeIsNotNull() {
            addCriterion("popularize_type is not null");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeEqualTo(Integer value) {
            addCriterion("popularize_type =", value, "popularizeType");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeNotEqualTo(Integer value) {
            addCriterion("popularize_type <>", value, "popularizeType");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeGreaterThan(Integer value) {
            addCriterion("popularize_type >", value, "popularizeType");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("popularize_type >=", value, "popularizeType");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeLessThan(Integer value) {
            addCriterion("popularize_type <", value, "popularizeType");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("popularize_type <=", value, "popularizeType");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeIn(List<Integer> values) {
            addCriterion("popularize_type in", values, "popularizeType");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeNotIn(List<Integer> values) {
            addCriterion("popularize_type not in", values, "popularizeType");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeBetween(Integer value1, Integer value2) {
            addCriterion("popularize_type between", value1, value2, "popularizeType");
            return (Criteria) this;
        }

        public Criteria andPopularizeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("popularize_type not between", value1, value2, "popularizeType");
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