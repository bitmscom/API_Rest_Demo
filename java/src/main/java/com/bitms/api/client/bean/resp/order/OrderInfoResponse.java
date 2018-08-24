package com.bitms.api.client.bean.resp.order;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @version : 1.0
 * @discription : order information
 * @create : 2018-08-14-10
 **/
public class OrderInfoResponse {

    private Long accountId;

    private Long orderId;

    private BigDecimal price;

    private String source;

    private String state;

    private String symbol;

    private String type;

    private String direct;

    private BigDecimal amount;

    private BigDecimal dealAmount;

    private BigDecimal dealBalance;

    private BigDecimal dealFee;

    private Timestamp finishedTime;

    private Timestamp canceleTime;

    private Date createdTime;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }

    public BigDecimal getDealBalance() {
        return dealBalance;
    }

    public void setDealBalance(BigDecimal dealBalance) {
        this.dealBalance = dealBalance;
    }

    public BigDecimal getDealFee() {
        return dealFee;
    }

    public void setDealFee(BigDecimal dealFee) {
        this.dealFee = dealFee;
    }

    public Timestamp getFinishedTime() {
        return finishedTime;
    }

    public void setFinishedTime(Timestamp finishedTime) {
        this.finishedTime = finishedTime;
    }

    public Timestamp getCanceleTime() {
        return canceleTime;
    }

    public void setCanceleTime(Timestamp canceleTime) {
        this.canceleTime = canceleTime;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
