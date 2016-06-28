package com.hy.dao.mybatis.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InvoiceCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Integer limitStart;

    protected Integer limitEnd;

    public InvoiceCriteria() {
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

        public Criteria andInvoiceEncodingIsNull() {
            addCriterion("invoice_encoding is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingIsNotNull() {
            addCriterion("invoice_encoding is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingEqualTo(String value) {
            addCriterion("invoice_encoding =", value, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingNotEqualTo(String value) {
            addCriterion("invoice_encoding <>", value, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingGreaterThan(String value) {
            addCriterion("invoice_encoding >", value, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_encoding >=", value, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingLessThan(String value) {
            addCriterion("invoice_encoding <", value, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingLessThanOrEqualTo(String value) {
            addCriterion("invoice_encoding <=", value, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingLike(String value) {
            addCriterion("invoice_encoding like", value, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingNotLike(String value) {
            addCriterion("invoice_encoding not like", value, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingIn(List<String> values) {
            addCriterion("invoice_encoding in", values, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingNotIn(List<String> values) {
            addCriterion("invoice_encoding not in", values, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingBetween(String value1, String value2) {
            addCriterion("invoice_encoding between", value1, value2, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andInvoiceEncodingNotBetween(String value1, String value2) {
            addCriterion("invoice_encoding not between", value1, value2, "invoiceEncoding");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNull() {
            addCriterion("tax_rate is null");
            return (Criteria) this;
        }

        public Criteria andTaxRateIsNotNull() {
            addCriterion("tax_rate is not null");
            return (Criteria) this;
        }

        public Criteria andTaxRateEqualTo(Integer value) {
            addCriterion("tax_rate =", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotEqualTo(Integer value) {
            addCriterion("tax_rate <>", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThan(Integer value) {
            addCriterion("tax_rate >", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("tax_rate >=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThan(Integer value) {
            addCriterion("tax_rate <", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateLessThanOrEqualTo(Integer value) {
            addCriterion("tax_rate <=", value, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateIn(List<Integer> values) {
            addCriterion("tax_rate in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotIn(List<Integer> values) {
            addCriterion("tax_rate not in", values, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateBetween(Integer value1, Integer value2) {
            addCriterion("tax_rate between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andTaxRateNotBetween(Integer value1, Integer value2) {
            addCriterion("tax_rate not between", value1, value2, "taxRate");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(Integer value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(Integer value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(Integer value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(Integer value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<Integer> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<Integer> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(Integer value1, Integer value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("category not between", value1, value2, "category");
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

        public Criteria andProposerUserIsNull() {
            addCriterion("proposer_user is null");
            return (Criteria) this;
        }

        public Criteria andProposerUserIsNotNull() {
            addCriterion("proposer_user is not null");
            return (Criteria) this;
        }

        public Criteria andProposerUserEqualTo(Integer value) {
            addCriterion("proposer_user =", value, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andProposerUserNotEqualTo(Integer value) {
            addCriterion("proposer_user <>", value, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andProposerUserGreaterThan(Integer value) {
            addCriterion("proposer_user >", value, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andProposerUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("proposer_user >=", value, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andProposerUserLessThan(Integer value) {
            addCriterion("proposer_user <", value, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andProposerUserLessThanOrEqualTo(Integer value) {
            addCriterion("proposer_user <=", value, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andProposerUserIn(List<Integer> values) {
            addCriterion("proposer_user in", values, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andProposerUserNotIn(List<Integer> values) {
            addCriterion("proposer_user not in", values, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andProposerUserBetween(Integer value1, Integer value2) {
            addCriterion("proposer_user between", value1, value2, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andProposerUserNotBetween(Integer value1, Integer value2) {
            addCriterion("proposer_user not between", value1, value2, "proposerUser");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNull() {
            addCriterion("invoice_title is null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIsNotNull() {
            addCriterion("invoice_title is not null");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleEqualTo(String value) {
            addCriterion("invoice_title =", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotEqualTo(String value) {
            addCriterion("invoice_title <>", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThan(String value) {
            addCriterion("invoice_title >", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleGreaterThanOrEqualTo(String value) {
            addCriterion("invoice_title >=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThan(String value) {
            addCriterion("invoice_title <", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLessThanOrEqualTo(String value) {
            addCriterion("invoice_title <=", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleLike(String value) {
            addCriterion("invoice_title like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotLike(String value) {
            addCriterion("invoice_title not like", value, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleIn(List<String> values) {
            addCriterion("invoice_title in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotIn(List<String> values) {
            addCriterion("invoice_title not in", values, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleBetween(String value1, String value2) {
            addCriterion("invoice_title between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andInvoiceTitleNotBetween(String value1, String value2) {
            addCriterion("invoice_title not between", value1, value2, "invoiceTitle");
            return (Criteria) this;
        }

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyIsNull() {
            addCriterion("proposer_money is null");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyIsNotNull() {
            addCriterion("proposer_money is not null");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyEqualTo(BigDecimal value) {
            addCriterion("proposer_money =", value, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyNotEqualTo(BigDecimal value) {
            addCriterion("proposer_money <>", value, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyGreaterThan(BigDecimal value) {
            addCriterion("proposer_money >", value, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("proposer_money >=", value, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyLessThan(BigDecimal value) {
            addCriterion("proposer_money <", value, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("proposer_money <=", value, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyIn(List<BigDecimal> values) {
            addCriterion("proposer_money in", values, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyNotIn(List<BigDecimal> values) {
            addCriterion("proposer_money not in", values, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proposer_money between", value1, value2, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("proposer_money not between", value1, value2, "proposerMoney");
            return (Criteria) this;
        }

        public Criteria andProposerTimeIsNull() {
            addCriterion("proposer_time is null");
            return (Criteria) this;
        }

        public Criteria andProposerTimeIsNotNull() {
            addCriterion("proposer_time is not null");
            return (Criteria) this;
        }

        public Criteria andProposerTimeEqualTo(Long value) {
            addCriterion("proposer_time =", value, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andProposerTimeNotEqualTo(Long value) {
            addCriterion("proposer_time <>", value, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andProposerTimeGreaterThan(Long value) {
            addCriterion("proposer_time >", value, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andProposerTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("proposer_time >=", value, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andProposerTimeLessThan(Long value) {
            addCriterion("proposer_time <", value, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andProposerTimeLessThanOrEqualTo(Long value) {
            addCriterion("proposer_time <=", value, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andProposerTimeIn(List<Long> values) {
            addCriterion("proposer_time in", values, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andProposerTimeNotIn(List<Long> values) {
            addCriterion("proposer_time not in", values, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andProposerTimeBetween(Long value1, Long value2) {
            addCriterion("proposer_time between", value1, value2, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andProposerTimeNotBetween(Long value1, Long value2) {
            addCriterion("proposer_time not between", value1, value2, "proposerTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyIsNull() {
            addCriterion("on_invoice_money is null");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyIsNotNull() {
            addCriterion("on_invoice_money is not null");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyEqualTo(BigDecimal value) {
            addCriterion("on_invoice_money =", value, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyNotEqualTo(BigDecimal value) {
            addCriterion("on_invoice_money <>", value, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyGreaterThan(BigDecimal value) {
            addCriterion("on_invoice_money >", value, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("on_invoice_money >=", value, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyLessThan(BigDecimal value) {
            addCriterion("on_invoice_money <", value, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("on_invoice_money <=", value, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyIn(List<BigDecimal> values) {
            addCriterion("on_invoice_money in", values, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyNotIn(List<BigDecimal> values) {
            addCriterion("on_invoice_money not in", values, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("on_invoice_money between", value1, value2, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("on_invoice_money not between", value1, value2, "onInvoiceMoney");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoIsNull() {
            addCriterion("on_invoice_paper_no is null");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoIsNotNull() {
            addCriterion("on_invoice_paper_no is not null");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoEqualTo(Integer value) {
            addCriterion("on_invoice_paper_no =", value, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoNotEqualTo(Integer value) {
            addCriterion("on_invoice_paper_no <>", value, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoGreaterThan(Integer value) {
            addCriterion("on_invoice_paper_no >", value, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("on_invoice_paper_no >=", value, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoLessThan(Integer value) {
            addCriterion("on_invoice_paper_no <", value, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoLessThanOrEqualTo(Integer value) {
            addCriterion("on_invoice_paper_no <=", value, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoIn(List<Integer> values) {
            addCriterion("on_invoice_paper_no in", values, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoNotIn(List<Integer> values) {
            addCriterion("on_invoice_paper_no not in", values, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoBetween(Integer value1, Integer value2) {
            addCriterion("on_invoice_paper_no between", value1, value2, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andOnInvoicePaperNoNotBetween(Integer value1, Integer value2) {
            addCriterion("on_invoice_paper_no not between", value1, value2, "onInvoicePaperNo");
            return (Criteria) this;
        }

        public Criteria andNumberIsNull() {
            addCriterion("number is null");
            return (Criteria) this;
        }

        public Criteria andNumberIsNotNull() {
            addCriterion("number is not null");
            return (Criteria) this;
        }

        public Criteria andNumberEqualTo(String value) {
            addCriterion("number =", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotEqualTo(String value) {
            addCriterion("number <>", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThan(String value) {
            addCriterion("number >", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberGreaterThanOrEqualTo(String value) {
            addCriterion("number >=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThan(String value) {
            addCriterion("number <", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLessThanOrEqualTo(String value) {
            addCriterion("number <=", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberLike(String value) {
            addCriterion("number like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotLike(String value) {
            addCriterion("number not like", value, "number");
            return (Criteria) this;
        }

        public Criteria andNumberIn(List<String> values) {
            addCriterion("number in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotIn(List<String> values) {
            addCriterion("number not in", values, "number");
            return (Criteria) this;
        }

        public Criteria andNumberBetween(String value1, String value2) {
            addCriterion("number between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andNumberNotBetween(String value1, String value2) {
            addCriterion("number not between", value1, value2, "number");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeIsNull() {
            addCriterion("on_invoice_time is null");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeIsNotNull() {
            addCriterion("on_invoice_time is not null");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeEqualTo(Long value) {
            addCriterion("on_invoice_time =", value, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeNotEqualTo(Long value) {
            addCriterion("on_invoice_time <>", value, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeGreaterThan(Long value) {
            addCriterion("on_invoice_time >", value, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeGreaterThanOrEqualTo(Long value) {
            addCriterion("on_invoice_time >=", value, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeLessThan(Long value) {
            addCriterion("on_invoice_time <", value, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeLessThanOrEqualTo(Long value) {
            addCriterion("on_invoice_time <=", value, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeIn(List<Long> values) {
            addCriterion("on_invoice_time in", values, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeNotIn(List<Long> values) {
            addCriterion("on_invoice_time not in", values, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeBetween(Long value1, Long value2) {
            addCriterion("on_invoice_time between", value1, value2, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceTimeNotBetween(Long value1, Long value2) {
            addCriterion("on_invoice_time not between", value1, value2, "onInvoiceTime");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserIsNull() {
            addCriterion("on_invoice_user is null");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserIsNotNull() {
            addCriterion("on_invoice_user is not null");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserEqualTo(Integer value) {
            addCriterion("on_invoice_user =", value, "onInvoiceUser");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserNotEqualTo(Integer value) {
            addCriterion("on_invoice_user <>", value, "onInvoiceUser");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserGreaterThan(Integer value) {
            addCriterion("on_invoice_user >", value, "onInvoiceUser");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("on_invoice_user >=", value, "onInvoiceUser");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserLessThan(Integer value) {
            addCriterion("on_invoice_user <", value, "onInvoiceUser");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserLessThanOrEqualTo(Integer value) {
            addCriterion("on_invoice_user <=", value, "onInvoiceUser");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserIn(List<Integer> values) {
            addCriterion("on_invoice_user in", values, "onInvoiceUser");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserNotIn(List<Integer> values) {
            addCriterion("on_invoice_user not in", values, "onInvoiceUser");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserBetween(Integer value1, Integer value2) {
            addCriterion("on_invoice_user between", value1, value2, "onInvoiceUser");
            return (Criteria) this;
        }

        public Criteria andOnInvoiceUserNotBetween(Integer value1, Integer value2) {
            addCriterion("on_invoice_user not between", value1, value2, "onInvoiceUser");
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