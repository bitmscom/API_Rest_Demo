package com.bitms.api.client.bean.resp.fund;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @version : 1.0
 * @discription : Leverage account information
 * @create : 2018-07-26-19
 **/
public class AccountAssetBean implements Serializable {

    private static final long serialVersionUID = 8402507123972150244L;

    /**
     * currency
     */
    private String currency;

    /**
     * Account Amount
     */
    private BigDecimal amount;

    /**
     * Freeze Amount
     */
    private BigDecimal frozenAmount;

    /**
     * Loan Amount
     */
    private BigDecimal loanAmount;

    /**
     * Mark available Amount
     */
    private BigDecimal markAvailableAmount;

    /**
     * real available Amount
     */
    private BigDecimal realAvailableAmount;

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

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getMarkAvailableAmount() {
        return markAvailableAmount;
    }

    public void setMarkAvailableAmount(BigDecimal markAvailableAmount) {
        this.markAvailableAmount = markAvailableAmount;
    }

    public BigDecimal getRealAvailableAmount() {
        return realAvailableAmount;
    }

    public void setRealAvailableAmount(BigDecimal realAvailableAmount) {
        this.realAvailableAmount = realAvailableAmount;
    }
}
