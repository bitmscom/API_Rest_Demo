package com.bitms.api.client.service.impl;

import com.bitms.api.client.ApiClient;
import com.bitms.api.client.DefaultApiClient;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.bean.test.ApiBitmsRequest;
import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.constant.BitmsConstants;
import com.bitms.api.client.service.FundService;
import com.bitms.api.client.service.bean.*;

/**
 * @version : 1.0
 * @program : com.bitms.api.rest.service.impl
 * @discription : Fund Service
 * @create : 2018-08-20-13
 **/
public class FundServiceImpl implements FundService {

    private String encryptKey;

    public FundServiceImpl(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public ApiResponse getPureSpotAsset(PureSpotBean data) {
        String[] data1 = {BitmsConst.ROOT + "fund/pureSpotAsset", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        return response;
    }

    public ApiResponse getLeveragedAccountInfo(LeveragedSpotBean data) {
        String[] data1 = {BitmsConst.ROOT + "fund/leveragedAccountInfo", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        return response;
    }

    public ApiResponse withdrawBitms(WithdrawBean data) {
        String[] data1 = {BitmsConst.ROOT + "fund/withdraw", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        return response;
    }

    public ApiResponse withdrawCancel(WithdrawCancelBean data) {
        String[] data1 = {BitmsConst.ROOT + "fund/withdraw_cancel", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        return response;
    }

    public ApiResponse withdrawRecords(WithdrawRecordBean data) {
        String[] data1 = {BitmsConst.ROOT + "fund/withdraw_records", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        return response;
    }

    public ApiResponse depositRecords(WithdrawRecordBean data) {
        String[] data1 = {BitmsConst.ROOT + "fund/deposit_records", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        return response;
    }

}
