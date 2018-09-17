package com.bitms.api.client.quotation;


import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.tool.HttpUtils;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;

/**
 * Quotetion test
 */
public class TestQuotationController {

    private String root = BitmsConst.ROOT;

    /**
     * Test to get public quotes
     */
    @Test
    public void testTicker() {
        Map<String, String> data = Maps.newHashMap();
        data.put("symbol", "btc2usd");
        String json = HttpUtils.get(root + "ticker", data);
        System.out.println(json);
    }

    /**
     * Test K-line market
     */
    @Test
    public void testKline() {
        Map<String, String> data = Maps.newHashMap();
        data.put("symbol", "btc2usd");
        data.put("type", "hour");
        String json = HttpUtils.get(root + "ticker");
        System.out.println(json);
    }

    /**
     * Test depth market
     */
    @Test
    public void testDepth() {
        Map<String, String> data = Maps.newHashMap();
        data.put("symbol", "btc2usd");
        String json = HttpUtils.get(root + "depth");
        System.out.println(json);
    }

    /**
     * Test transaction record
     */
    @Test
    public void testTrades() {
        Map<String, String> data = Maps.newHashMap();
        data.put("symbol", "btc2usd");
        String json = HttpUtils.get(root + "trades");
        System.out.println(json);
    }

}
