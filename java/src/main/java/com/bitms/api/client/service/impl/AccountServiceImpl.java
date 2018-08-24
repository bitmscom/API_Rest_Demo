package com.bitms.api.client.service.impl;

import com.bitms.api.client.ApiClient;
import com.bitms.api.client.DefaultApiClient;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.bean.test.ApiBitmsRequest;
import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.constant.BitmsConstants;
import com.bitms.api.client.service.AccountService;

/**
 * @version : 1.0
 * @program : com.bitms.api.client.service.impl
 * @discription : account service
 * @create : 2018-08-20-14
 **/
public class AccountServiceImpl implements AccountService {

    private String encryptKey;

    public AccountServiceImpl(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public ApiResponse getAccountInfo() {
        String[] data1 = {BitmsConst.ROOT + "account/info", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        return response;
    }
}
