package com.bitms.api.client.trade.order.bean;


import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

/**
 * @version : 1.0
 * @discription : Transaction cancellation
 * @create : 2018-07-07-16
 **/
public class EntrustCancelBean extends BitmsObject {

    /**
     * Order ID
     */
    @ApiField("orderId")
    private Long orderId;

    /**
     * Transaction pair
     */
    @ApiField("symbol")
    private String symbol;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
