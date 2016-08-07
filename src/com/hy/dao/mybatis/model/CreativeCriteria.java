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

        public Criteria andCreativeTypeIsNull() {
            addCriterion("creative_type is null");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeIsNotNull() {
            addCriterion("creative_type is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeEqualTo(String value) {
            addCriterion("creative_type =", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeNotEqualTo(String value) {
            addCriterion("creative_type <>", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeGreaterThan(String value) {
            addCriterion("creative_type >", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("creative_type >=", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeLessThan(String value) {
            addCriterion("creative_type <", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeLessThanOrEqualTo(String value) {
            addCriterion("creative_type <=", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeLike(String value) {
            addCriterion("creative_type like", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeNotLike(String value) {
            addCriterion("creative_type not like", value, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeIn(List<String> values) {
            addCriterion("creative_type in", values, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeNotIn(List<String> values) {
            addCriterion("creative_type not in", values, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeBetween(String value1, String value2) {
            addCriterion("creative_type between", value1, value2, "creativeType");
            return (Criteria) this;
        }

        public Criteria andCreativeTypeNotBetween(String value1, String value2) {
            addCriterion("creative_type not between", value1, value2, "creativeType");
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

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityIsNull() {
            addCriterion("creative_modality is null");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityIsNotNull() {
            addCriterion("creative_modality is not null");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityEqualTo(String value) {
            addCriterion("creative_modality =", value, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityNotEqualTo(String value) {
            addCriterion("creative_modality <>", value, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityGreaterThan(String value) {
            addCriterion("creative_modality >", value, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityGreaterThanOrEqualTo(String value) {
            addCriterion("creative_modality >=", value, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityLessThan(String value) {
            addCriterion("creative_modality <", value, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityLessThanOrEqualTo(String value) {
            addCriterion("creative_modality <=", value, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityLike(String value) {
            addCriterion("creative_modality like", value, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityNotLike(String value) {
            addCriterion("creative_modality not like", value, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityIn(List<String> values) {
            addCriterion("creative_modality in", values, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityNotIn(List<String> values) {
            addCriterion("creative_modality not in", values, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityBetween(String value1, String value2) {
            addCriterion("creative_modality between", value1, value2, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andCreativeModalityNotBetween(String value1, String value2) {
            addCriterion("creative_modality not between", value1, value2, "creativeModality");
            return (Criteria) this;
        }

        public Criteria andSizeIsNull() {
            addCriterion("size is null");
            return (Criteria) this;
        }

        public Criteria andSizeIsNotNull() {
            addCriterion("size is not null");
            return (Criteria) this;
        }

        public Criteria andSizeEqualTo(String value) {
            addCriterion("size =", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotEqualTo(String value) {
            addCriterion("size <>", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThan(String value) {
            addCriterion("size >", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeGreaterThanOrEqualTo(String value) {
            addCriterion("size >=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThan(String value) {
            addCriterion("size <", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLessThanOrEqualTo(String value) {
            addCriterion("size <=", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeLike(String value) {
            addCriterion("size like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotLike(String value) {
            addCriterion("size not like", value, "size");
            return (Criteria) this;
        }

        public Criteria andSizeIn(List<String> values) {
            addCriterion("size in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotIn(List<String> values) {
            addCriterion("size not in", values, "size");
            return (Criteria) this;
        }

        public Criteria andSizeBetween(String value1, String value2) {
            addCriterion("size between", value1, value2, "size");
            return (Criteria) this;
        }

        public Criteria andSizeNotBetween(String value1, String value2) {
            addCriterion("size not between", value1, value2, "size");
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

        public Criteria andProcessStateIsNull() {
            addCriterion("process_state is null");
            return (Criteria) this;
        }

        public Criteria andProcessStateIsNotNull() {
            addCriterion("process_state is not null");
            return (Criteria) this;
        }

        public Criteria andProcessStateEqualTo(Integer value) {
            addCriterion("process_state =", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateNotEqualTo(Integer value) {
            addCriterion("process_state <>", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateGreaterThan(Integer value) {
            addCriterion("process_state >", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("process_state >=", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateLessThan(Integer value) {
            addCriterion("process_state <", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateLessThanOrEqualTo(Integer value) {
            addCriterion("process_state <=", value, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateIn(List<Integer> values) {
            addCriterion("process_state in", values, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateNotIn(List<Integer> values) {
            addCriterion("process_state not in", values, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateBetween(Integer value1, Integer value2) {
            addCriterion("process_state between", value1, value2, "processState");
            return (Criteria) this;
        }

        public Criteria andProcessStateNotBetween(Integer value1, Integer value2) {
            addCriterion("process_state not between", value1, value2, "processState");
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