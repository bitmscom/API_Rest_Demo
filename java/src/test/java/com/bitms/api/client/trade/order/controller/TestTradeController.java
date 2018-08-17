package com.bitms.api.client.trade.order.controller;

import com.bitms.api.client.ApiClient;
import com.bitms.api.client.DefaultApiClient;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.bean.test.ApiBitmsRequest;
import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.constant.BitmsConstants;
import com.bitms.api.client.trade.order.bean.*;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @version : 1.0
 * @discription : Test transaction controller
 * @create : 2018-07-07-16
 **/
public class TestTradeController {

    private String root = BitmsConst.ROOT;

    //Bitms
    private String apiKey = BitmsConst.apiKey;
    //private key
    private String priKey = BitmsConst.priKey;

    /**
     * Single order
     * @throws Exception
     */
    @Test
    public void doMatchRequest() throws Exception {
        String[] data1 = {root + "order/orders", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        EntrustBean data = new EntrustBean();
        data.setAmount(new BigDecimal("0.01"));
        data.setDirect("buy");
        data.setPrice(new BigDecimal(9100));
        data.setSymbol("btc2usd");
        data.setType("limit");
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        System.out.println(response.getBody());
    }

    /**
     * Transaction cancellation (single stroke)
     * @throws Exception
     */
    @Test
    public void doMatchCancelRequest() throws Exception {
        String[] data1 = {root + "order/order_cancel", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        EntrustCancelBean data = new EntrustCancelBean();
        data.setOrderId(121110608182513664l);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        System.out.println(response.getBody());
    }

    /**
     * Transaction cancellation (multiple)
     * @throws Exception
     */
    @Test
    public void doMatchCancelBatchRequest() throws Exception {
        String[] data1 = {root + "order/order_cancel_batch", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        OrderCancelbatchBean data = new OrderCancelbatchBean();
        List<Long> req = Lists.newArrayList();
        req.add(120778993690480640l);
        req.add(120778994701307904l);
        data.setOrderIds(req);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        System.out.println(response.getBody());
    }

    /**
     * Query order details
     * @throws Exception
     */
    @Test
    public void searchOrderInfo() throws Exception {
        String[] data1 = {root + "order/order_info", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        OrderInfoBean data = new OrderInfoBean();
        data.setOrderId(123590473188118528l);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }

    /**
     * Query order transaction details
     * @throws Exception
     */
    @Test
    public void searchDealInfo() throws Exception {
        String[] data1 = {root + "order/deal_info", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        OrderInfoBean data = new OrderInfoBean();
        data.setOrderId(123590473188118528l);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }

    /**
     * Current delegation list
     * @throws Exception
     */
    @Test
    public void entrustxOnDoingRequest() throws Exception {
        String[] data1 = {root + "order/order_current", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        OrderCurrentBean data = new OrderCurrentBean();
        data.setDirect("sell");
        data.setSymbol("btc2usd");
        data.setType("limit");
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }

    /**
     * Historical delegation list
     * @throws Exception
     */
    @Test
    public void testDoMatchRequest() throws Exception {
        String[] data1 = {root + "order/order_history", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        OrderCurrentBean data = new OrderCurrentBean();
        data.setPage(1);
        data.setRows(10);
        data.setDirect("buy");
        data.setSymbol("btc2usd");
        data.setType("limit");
        data.setState("pre-submitted,submitted");
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }

}
