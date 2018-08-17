package com.bitms.api.client.trade.account.controller;

import com.bitms.api.client.ApiClient;
import com.bitms.api.client.DefaultApiClient;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.bean.test.ApiBitmsRequest;
import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.constant.BitmsConstants;
import com.bitms.api.client.tool.HttpUtils;
import com.bitms.api.client.trade.account.bean.UserInfoTest;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * @version : 1.0
 * @discription : Account test class
 * @create : 2018-07-07-14
 **/
public class TestAccountController {

    private String root = BitmsConst.ROOT;

    //Bitms
    private String apiKey = BitmsConst.apiKey;
    //private key
    private String priKey = BitmsConst.priKey;

    /**
     * Get user information
     * @throws Exception
     */
    @Test
    public void testGetAccountInfo() throws Exception {
        String[] data1 = {root + "account/info", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        UserInfoTest data = new UserInfoTest();
        data.setApi_key(this.apiKey);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }
}
