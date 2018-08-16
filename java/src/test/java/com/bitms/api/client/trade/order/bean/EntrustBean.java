package com.bitms.api.client.trade.order.bean;


import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

import java.math.BigDecimal;

/**
 * @author : yukai
 * @version : 1.0
 * @discription : 下单bean
 * @create : 2018-07-07-16
 **/
public class EntrustBean extends BitmsObject {

    /**
     * 交易对
     */
    @ApiField("symbol")
    private String symbol;

    /**
     * 委托类型
     */
    @ApiField("type")
    private String type;

    /**
     * 委托方向
     */
    @ApiField("direct")
    private String direct;

    /**
     * 委托数量
     */
    @ApiField("amount")
    private BigDecimal amount;

    /**
     * 委托价格
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
