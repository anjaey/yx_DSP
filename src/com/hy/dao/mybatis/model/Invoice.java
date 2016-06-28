package com.hy.dao.mybatis.model;

import java.math.BigDecimal;

public class Invoice {
    private Integer id;

    private String invoiceEncoding;

    private Integer type;

    private Integer taxRate;

    private Integer category;

    private Long createTime;

    private Integer proposerUser;

    private String invoiceTitle;

    private String project;

    private BigDecimal proposerMoney;

    private Long proposerTime;

    private BigDecimal onInvoiceMoney;

    private Integer onInvoicePaperNo;

    private String number;

    private Long onInvoiceTime;

    private Integer onInvoiceUser;

    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvoiceEncoding() {
        return invoiceEncoding;
    }

    public void setInvoiceEncoding(String invoiceEncoding) {
        this.invoiceEncoding = invoiceEncoding == null ? null : invoiceEncoding.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Integer taxRate) {
        this.taxRate = taxRate;
    }

    public Integer getCategory() {
        return category;
    }

    public void setCategory(Integer category) {
        this.category = category;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Integer getProposerUser() {
        return proposerUser;
    }

    public void setProposerUser(Integer proposerUser) {
        this.proposerUser = proposerUser;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public BigDecimal getProposerMoney() {
        return proposerMoney;
    }

    public void setProposerMoney(BigDecimal proposerMoney) {
        this.proposerMoney = proposerMoney;
    }

    public Long getProposerTime() {
        return proposerTime;
    }

    public void setProposerTime(Long proposerTime) {
        this.proposerTime = proposerTime;
    }

    public BigDecimal getOnInvoiceMoney() {
        return onInvoiceMoney;
    }

    public void setOnInvoiceMoney(BigDecimal onInvoiceMoney) {
        this.onInvoiceMoney = onInvoiceMoney;
    }

    public Integer getOnInvoicePaperNo() {
        return onInvoicePaperNo;
    }

    public void setOnInvoicePaperNo(Integer onInvoicePaperNo) {
        this.onInvoicePaperNo = onInvoicePaperNo;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Long getOnInvoiceTime() {
        return onInvoiceTime;
    }

    public void setOnInvoiceTime(Long onInvoiceTime) {
        this.onInvoiceTime = onInvoiceTime;
    }

    public Integer getOnInvoiceUser() {
        return onInvoiceUser;
    }

    public void setOnInvoiceUser(Integer onInvoiceUser) {
        this.onInvoiceUser = onInvoiceUser;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}