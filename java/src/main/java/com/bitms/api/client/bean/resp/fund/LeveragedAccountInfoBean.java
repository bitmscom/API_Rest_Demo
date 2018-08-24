package com.bitms.api.client.bean.resp.fund;

import java.math.BigDecimal;

/**
 * @version : 1.0
 * @discription : Contract account information
 * @create : 2018-08-15-14
 **/
public class LeveragedAccountInfoBean {

    /**
     * Account Fund Asset
     */
    private BigDecimal accountFundAsset;

    /**
     * Current position(usd)
     */
    private BigDecimal accountPositionValue;

    /**
     * Weekly profit and loss
     */
    private BigDecimal profitAndLoss;

    /**
     * Estimate explosion Price
     */
    private BigDecimal explosionPrice;

    public BigDecimal getAccountFundAsset() {
        return accountFundAsset;
    }

    public void setAccountFundAsset(BigDecimal accountFundAsset) {
        this.accountFundAsset = accountFundAsset;
    }

    public BigDecimal getAccountPositionValue() {
        return accountPositionValue;
    }

    public void setAccountPositionValue(BigDecimal accountPositionValue) {
        this.accountPositionValue = accountPositionValue;
    }

    public BigDecimal getProfitAndLoss() {
        return profitAndLoss;
    }

    public void setProfitAndLoss(BigDecimal profitAndLoss) {
        this.profitAndLoss = profitAndLoss;
    }

    public BigDecimal getExplosionPrice() {
        return explosionPrice;
    }

    public void setExplosionPrice(BigDecimal explosionPrice) {
        this.explosionPrice = explosionPrice;
    }
}
