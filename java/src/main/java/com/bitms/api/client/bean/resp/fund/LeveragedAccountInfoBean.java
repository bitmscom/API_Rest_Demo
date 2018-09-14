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

    /**
     * account position direction
     */
    private String direction;

    /**
     * usd mark available Amount
     */
    private BigDecimal usdMarkAvailableAmount;

    /**
     * btc mark available Amount
     */
    private BigDecimal btcMarkAvailableAmount;

    /**
     * open position Average price
     */
    private BigDecimal openPositionAvg;

    /**
     * Settlement base price
     */
    private BigDecimal startPlatPrice;

    /**
     * initial deposit
     */
    private BigDecimal startMargin;

    /**
     * starting lever
     */
    private BigDecimal startLever;

    /**
     * real time leverage
     */
    private BigDecimal realTimeLeverage;

    /**
     * position profit
     */
    private BigDecimal profit;

    /**
     * profit rate
     */
    private BigDecimal profitRate;

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

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public BigDecimal getUsdMarkAvailableAmount() {
        return usdMarkAvailableAmount;
    }

    public void setUsdMarkAvailableAmount(BigDecimal usdMarkAvailableAmount) {
        this.usdMarkAvailableAmount = usdMarkAvailableAmount;
    }

    public BigDecimal getBtcMarkAvailableAmount() {
        return btcMarkAvailableAmount;
    }

    public void setBtcMarkAvailableAmount(BigDecimal btcMarkAvailableAmount) {
        this.btcMarkAvailableAmount = btcMarkAvailableAmount;
    }

    public BigDecimal getOpenPositionAvg() {
        return openPositionAvg;
    }

    public void setOpenPositionAvg(BigDecimal openPositionAvg) {
        this.openPositionAvg = openPositionAvg;
    }

    public BigDecimal getStartPlatPrice() {
        return startPlatPrice;
    }

    public void setStartPlatPrice(BigDecimal startPlatPrice) {
        this.startPlatPrice = startPlatPrice;
    }

    public BigDecimal getStartMargin() {
        return startMargin;
    }

    public void setStartMargin(BigDecimal startMargin) {
        this.startMargin = startMargin;
    }

    public BigDecimal getStartLever() {
        return startLever;
    }

    public void setStartLever(BigDecimal startLever) {
        this.startLever = startLever;
    }

    public BigDecimal getRealTimeLeverage() {
        return realTimeLeverage;
    }

    public void setRealTimeLeverage(BigDecimal realTimeLeverage) {
        this.realTimeLeverage = realTimeLeverage;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }

    public void setProfitRate(BigDecimal profitRate) {
        this.profitRate = profitRate;
    }
}
