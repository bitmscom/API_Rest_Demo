package com.bitms.api.client.service.bean;

import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

/**
 * @version : 1.0
 * @program : com.bitms.api.client.trade.fund.bean
 * @discription : Pure spot bean
 * @create : 2018-07-25-15
 **/
public class PureSpotBean extends BitmsObject {

    @ApiField("currency")
    private String currency;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
