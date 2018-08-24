package com.bitms.api.client.service.impl;

import com.bitms.api.client.ApiClient;
import com.bitms.api.client.DefaultApiClient;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.bean.test.ApiBitmsRequest;
import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.constant.BitmsConstants;
import com.bitms.api.client.service.OrderService;
import com.bitms.api.client.service.bean.*;

/**
 * @version : 1.0
 * @program : com.bitms.api.client.service.impl
 * @discription : order service
 * @create : 2018-08-20-14
 **/
public class OrderServiceImpl implements OrderService {

    private String encryptKey;

    public OrderServiceImpl(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    public ApiResponse doMatchRequest(EntrustBean data) {
        String[] data1 = {BitmsConst.ROOT + "order/orders", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        return response;
    }

    public ApiResponse doMatchCancelRequest(EntrustCancelBean data) {
        String[] data1 = {BitmsConst.ROOT + "order/order_cancel", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        return response;
    }

    public ApiResponse doMatchCancelBatchRequest(OrderCancelbatchBean data) {
        String[] data1 = {BitmsConst.ROOT + "order/order_cancel_batch", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        return response;
    }

    public ApiResponse searchOrderInfo(OrderInfoBean data) {
        String[] data1 = {BitmsConst.ROOT + "order/order_info", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        return response;
    }

    public ApiResponse searchDealInfo(OrderInfoBean data) {
        String[] data1 = {BitmsConst.ROOT + "order/deal_info", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        return response;
    }

    public ApiResponse entrustxOnDoingRequest(OrderCurrentBean data) {
        String[] data1 = {BitmsConst.ROOT + "order/order_current", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        return response;
    }

    public ApiResponse testDoMatchRequest(OrderCurrentBean data) {
        String[] data1 = {BitmsConst.ROOT + "order/order_history", BitmsConst.PRIKEY, encryptKey, BitmsConst.APIKEY};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        return response;
    }

}
