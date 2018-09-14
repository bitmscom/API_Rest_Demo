package com.bitms.api.client.bean.resp.order;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @version : 1.0
 * @discription : Transaction details
 * @create : 2018-07-17-14
 **/
public class DealInfoResponse {

    /**
     * symbol
     */
    private String symbol;

    /**
     * deal amount
     */
    private BigDecimal dealAmount;

    /**
     * deal ID
     */
    private Long dealId;

    /**
     * order ID
     */
    private Long orderId;

    /**
     * create time
     */
    private Timestamp dealTime;

    /**
     * order source
     */
    private String source;

    /**
     * order type
     */
    private String type;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }

    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDealTime() {
        return dealTime;
    }

    public void setDealTime(Timestamp dealTime) {
        this.dealTime = dealTime;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
