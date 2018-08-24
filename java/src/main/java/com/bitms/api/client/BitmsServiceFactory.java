package com.bitms.api.client;

import com.bitms.api.client.service.AccountService;
import com.bitms.api.client.service.FundService;
import com.bitms.api.client.service.OrderService;
import com.bitms.api.client.service.impl.AccountServiceImpl;
import com.bitms.api.client.service.impl.FundServiceImpl;
import com.bitms.api.client.service.impl.OrderServiceImpl;

import java.util.UUID;

/**
 * @version : 1.0
 * @program : com.bitms.api.client
 * @discription : service factory
 * @create : 2018-08-20-15
 **/
public class BitmsServiceFactory {

    private String encryptKey;

    public BitmsServiceFactory(String encryptKey) {
        this.encryptKey = encryptKey;
    }

    /**
     * New instance.
     *
     * @param encryptKey the encryptKey
     * @return the bitms api client factory
     */
    public static BitmsServiceFactory newInstance(String encryptKey) {
        return new BitmsServiceFactory(encryptKey);
    }

    /**
     * New instance.
     *
     * @return the bitms api client factory
     */
    public static BitmsServiceFactory newInstance() {
        return new BitmsServiceFactory(String.valueOf(UUID.randomUUID()));
    }

    /**
     * Creates a new fund service.
     */
    public FundService newFundService() {
        return new FundServiceImpl(encryptKey);
    }

    /**
     * Creates a new account service.
     */
    public AccountService newAccountService() {
        return new AccountServiceImpl(encryptKey);
    }

    /**
     * Creates a new order service.
     */
    public OrderService newOrderService() {
        return new OrderServiceImpl(encryptKey);
    }


}
