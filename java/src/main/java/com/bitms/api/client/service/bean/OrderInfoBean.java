package com.bitms.api.client.service.bean;

import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

/**
 * @version : 1.0
 * @discription : Order details bean
 * @create : 2018-07-07-17
 **/
public class OrderInfoBean extends BitmsObject {

    @ApiField("orderId")
    private Long orderId;

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
