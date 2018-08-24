package com.bitms.api.client.trade.order.controller;

import com.bitms.api.client.BitmsServiceFactory;
import com.bitms.api.client.bean.resp.order.CurrentOrderResponse;
import com.bitms.api.client.bean.resp.order.DealInfoResponse;
import com.bitms.api.client.bean.resp.order.OrderCancelResponse;
import com.bitms.api.client.bean.resp.order.OrderInfoResponse;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.service.OrderService;
import com.bitms.api.client.service.bean.*;
import com.bitms.api.client.tool.JSONUtils;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @version : 1.0
 * @discription : Test transaction controller
 * @create : 2018-07-07-16
 **/
public class TestTradeController {

    //Use timestamp as AES key
    BitmsServiceFactory factory = BitmsServiceFactory.newInstance(String.valueOf(System.currentTimeMillis()));

    OrderService orderService = factory.newOrderService();

    /**
     * Single order
     *
     * @throws Exception
     */
    @Test
    public void doMatchRequest() {
        EntrustBean data = new EntrustBean();
        data.setAmount(new BigDecimal("0.01"));
        data.setDirect("buy");
        data.setPrice(new BigDecimal(6000));
        data.setSymbol("btc2usd");
        data.setType("limit");
        ApiResponse response = orderService.doMatchRequest(data);
        System.out.println(response.getBody());
        Long result = (Long) response.getData();
        System.out.println(result);
    }

    /**
     * Transaction cancellation (single stroke)
     *
     * @throws Exception
     */
    @Test
    public void doMatchCancelRequest() {
        EntrustCancelBean data = new EntrustCancelBean();
        data.setOrderId(121110608182513664l);
        ApiResponse response = orderService.doMatchCancelRequest(data);
        System.out.println(response.getBody());
        Long result = (Long) response.getData();
        System.out.println(result);
    }

    /**
     * Transaction cancellation (multiple)
     *
     * @throws Exception
     */
    @Test
    public void doMatchCancelBatchRequest() {
        OrderCancelbatchBean data = new OrderCancelbatchBean();
        List<Long> req = Lists.newArrayList();
        req.add(120778993690480640l);
        req.add(120778994701307904l);
        data.setOrderIds(req);
        ApiResponse response = orderService.doMatchCancelBatchRequest(data);
        System.out.println(response.getBody());
        List<OrderCancelResponse> result = (List<OrderCancelResponse>) response.getData();
        System.out.println(result);
    }

    /**
     * Query order details
     *
     * @throws Exception
     */
    @Test
    public void searchOrderInfo() throws IOException {
        OrderInfoBean data = new OrderInfoBean();
        data.setOrderId(127282307307409408l);
        ApiResponse response = orderService.searchOrderInfo(data);
        System.out.println(response.getBody());
        String temp = JSONUtils.writeValue(response.getData());
        OrderInfoResponse result = JSONUtils.readValue(temp, OrderInfoResponse.class);
        System.out.println(result);
    }

    /**
     * Query order transaction details
     *
     * @throws Exception
     */
    @Test
    public void searchDealInfo() {
        OrderInfoBean data = new OrderInfoBean();
        data.setOrderId(123590473188118528l);
        ApiResponse response = orderService.searchDealInfo(data);
        System.out.println(response.getBody());
        List<DealInfoResponse> result = (List<DealInfoResponse>) response.getData();
        System.out.println(result);
    }

    /**
     * Current delegation list
     *
     * @throws Exception
     */
    @Test
    public void entrustxOnDoingRequest() {
        OrderCurrentBean data = new OrderCurrentBean();
        data.setDirect("sell");
        data.setSymbol("btc2usd");
        data.setType("limit");
//        data.setPage(1);
//        data.setRows(10);
        ApiResponse response = orderService.entrustxOnDoingRequest(data);
        System.out.println(response.getBody());
        Map<String, Object> result = (Map<String, Object>) response.getData();
        List<CurrentOrderResponse> resResult = (List<CurrentOrderResponse>) result.get("list");
        System.out.println(resResult);
    }

    /**
     * Historical delegation list
     *
     * @throws Exception
     */
    @Test
    public void testDoMatchRequest() {
        OrderCurrentBean data = new OrderCurrentBean();
        data.setPage(1);
        data.setRows(10);
        data.setDirect("buy");
        data.setSymbol("btc2usd");
        data.setType("limit");
        data.setState("partialDeal,allDeal");
        ApiResponse response = orderService.testDoMatchRequest(data);
        System.out.println(response.getBody());
        Map<String, Object> result = (Map<String, Object>) response.getData();
        List<CurrentOrderResponse> resResult = (List<CurrentOrderResponse>) result.get("list");
        System.out.println(resResult);
    }

}
