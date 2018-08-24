package com.bitms.api.client.trade.account.controller;

import com.bitms.api.client.BitmsServiceFactory;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.service.AccountService;
import org.junit.Test;

/**
 * @version : 1.0
 * @discription : Account test class
 * @create : 2018-07-07-14
 **/
public class TestAccountController {

    //Use timestamp as AES key
    BitmsServiceFactory factory = BitmsServiceFactory.newInstance(String.valueOf(System.currentTimeMillis()));

    AccountService accountService = factory.newAccountService();

    /**
     * Get user information
     *
     * @throws Exception
     */
    @Test
    public void testGetAccountInfo() {
        ApiResponse response = accountService.getAccountInfo();
        System.out.println(response.getBody());
    }
}
