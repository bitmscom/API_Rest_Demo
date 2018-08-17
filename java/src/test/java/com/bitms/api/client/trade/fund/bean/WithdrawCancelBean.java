package com.bitms.api.client.trade.fund.bean;


import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

/**
 * @version : 1.0
 * @discription : Cancel the currency bean
 * @create : 2018-07-07-15
 **/
public class WithdrawCancelBean extends BitmsObject {

    @ApiField("withdrawId")
    private Long withdrawId;

    public Long getWithdrawId() {
        return withdrawId;
    }

    public void setWithdrawId(Long withdrawId) {
        this.withdrawId = withdrawId;
    }
}
