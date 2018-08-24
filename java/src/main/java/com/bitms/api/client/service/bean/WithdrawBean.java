package com.bitms.api.client.service.bean;


import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

import java.math.BigDecimal;

/**
 * @version : 1.0
 * @discription : Coin withdrawal requesting bean
 * @create : 2018-07-05-10
 **/
public class WithdrawBean extends BitmsObject {

    @ApiField("address")
    private String address;

    @ApiField("currency")
    private String currency;

    @ApiField("amount")
    private BigDecimal amount;

    @ApiField("fundPwd")
    private String fundPwd;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public String getFundPwd() {
        return fundPwd;
    }

    public void setFundPwd(String fundPwd) {
        this.fundPwd = fundPwd;
    }
}
