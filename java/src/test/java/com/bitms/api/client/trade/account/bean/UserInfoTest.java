package com.bitms.api.client.trade.account.bean;

import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

/**
 * @author : yukai
 * @version : 1.0
 * @discription : 用户信息测试类
 * @create : 2018-07-06-16
 **/
public class UserInfoTest extends BitmsObject {

    @ApiField("api_key")
    private String api_key;

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }
}
