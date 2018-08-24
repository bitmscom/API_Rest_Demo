package com.bitms.api.client.bean.resp.order;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @version : 1.0
 * @discription : Current unfilled order
 * @create : 2018-07-16-11
 **/
public class CurrentOrderResponse {

    private Long id;

    private String symbol;

    private BigDecimal price;

    private Date createTime;

    private String type;

    private BigDecimal amount;

    private BigDecimal dealAmount;

    private BigDecimal dealBalance;

    private BigDecimal dealFee;

    private String source;

    private String state;

    private String direct;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }
}
