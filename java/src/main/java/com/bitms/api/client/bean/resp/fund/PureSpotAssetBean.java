package com.bitms.api.client.bean.resp.fund;

import java.math.BigDecimal;

/**
 * @version : 1.0
 * @discription : Pure spot assets
 * @create : 2018-08-15-20
 **/
public class PureSpotAssetBean {

    /**
     * currency
     */
    private String currency;

    /**
     * account amount
     */
    private BigDecimal amount;

    /**
     * Freeze amount
     */
    private BigDecimal frozenAmount;

    /**
     * Available amount
     */
    private BigDecimal availableAmount;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(BigDecimal frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public BigDecimal getAvailableAmount() {
        return availableAmount;
    }

    public void setAvailableAmount(BigDecimal availableAmount) {
        this.availableAmount = availableAmount;
    }
}
