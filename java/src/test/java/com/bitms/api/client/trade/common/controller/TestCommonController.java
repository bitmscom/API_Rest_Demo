package com.bitms.api.client.trade.common.controller;

import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.tool.HttpUtils;
import org.junit.Test;

/**
 * @author : yukai
 * @version : 1.0
 * @discription : 公共controller测试类
 * @create : 2018-07-07-14
 **/
public class TestCommonController {

    private String root = BitmsConst.ROOT;

    /**
     * 测试获取系统时间
     */
    @Test
    public void testGetTimestamp() {
        String json = HttpUtils.get(root + "common/timestamp");
        System.out.println(json);
    }

    /**
     * 测试获取所有币种
     */
    @Test
    public void testGetCurrencys() {
        String json = HttpUtils.get(root + "common/currencys");
        System.out.println(json);
    }

    /**
     * 测试获取所有交易对
     */
    @Test
    public void testGetSymbols() {
        String json = HttpUtils.get(root + "common/symbols");
        System.out.println(json);
    }

}
