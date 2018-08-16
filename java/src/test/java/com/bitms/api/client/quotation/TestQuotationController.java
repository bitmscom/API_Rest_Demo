package com.bitms.api.client.quotation;


import com.bitms.api.client.tool.HttpUtils;
import org.junit.Test;

/**
 * 公共行情测试类
 */
public class TestQuotationController {

    private String root = "http://localhost:8081/api/v1/";

    /**
     * 测试获取公共行情
     */
    @Test
    public void testTicker() {
        String json = HttpUtils.get(root + "ticker?symbol=biex2eth&");
        System.out.println(json);
    }

    /**
     * 测试K线行情
     */
    @Test
    public void testKline() {
        String json = HttpUtils.get(root + "ticker?symbol=biex2eth&type=hour");
        System.out.println(json);
    }

    /**
     * 测试盘口行情
     */
    @Test
    public void testDepth() {
        String json = HttpUtils.get(root + "depth?symbol=biex2eth&");
        System.out.println(json);
    }

    /**
     * 测试成交记录
     */
    @Test
    public void testTrades() {
        String json = HttpUtils.get(root + "trades?symbol=biex2eth&");
        System.out.println(json);
    }

}
