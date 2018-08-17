package com.bitms.api.client.quotation;


import com.bitms.api.client.tool.HttpUtils;
import org.junit.Test;

/**
 * Quotetion test
 */
public class TestQuotationController {

    private String root = "http://api.bitms.com/api/v1/";

    /**
     * Test to get public quotes
     */
    @Test
    public void testTicker() {
        String json = HttpUtils.get(root + "ticker?symbol=btc2usd&");
        System.out.println(json);
    }

    /**
     * Test K-line market
     */
    @Test
    public void testKline() {
        String json = HttpUtils.get(root + "ticker?symbol=btc2usd&type=hour");
        System.out.println(json);
    }

    /**
     * Test depth market
     */
    @Test
    public void testDepth() {
        String json = HttpUtils.get(root + "depth?symbol=btc2usd&");
        System.out.println(json);
    }

    /**
     * Test transaction record
     */
    @Test
    public void testTrades() {
        String json = HttpUtils.get(root + "trades?symbol=btc2usd&");
        System.out.println(json);
    }

}
