package com.bitms.api.client.service.bean;

import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

/**
 * @version : 1.0
 * @program : com.bitms.api.client.trade.fund.bean
 * @discription : Pure spot bean
 * @create : 2018-07-25-15
 **/
public class PureSpotBean extends BitmsObject{

    @ApiField("symbol")
    private String symbol;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
