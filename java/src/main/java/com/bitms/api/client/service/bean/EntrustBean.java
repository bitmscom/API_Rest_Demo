package com.bitms.api.client.service.bean;


import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

import java.math.BigDecimal;

/**
 * @version : 1.0
 * @discription : Order bean
 * @create : 2018-07-07-16
 **/
public class EntrustBean extends BitmsObject {

    /**
     * Transaction pair
     */
    @ApiField("symbol")
    private String symbol;

    /**
     * Entrustment type
     */
    @ApiField("type")
    private String type;

    /**
     * Commission direction
     */
    @ApiField("direct")
    private String direct;

    /**
     * Number of orders
     */
    @ApiField("amount")
    private BigDecimal amount;

    /**
     * Commission price
     */
    @ApiField("price")
    private BigDecimal price;

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
