package com.bitms.api.client.service;

import com.bitms.api.client.bean.sign.ApiResponse;

/**
 * @version : 1.0
 * @program : com.bitms.api.client.service
 * @discription : account service
 * @create : 2018-08-20-14
 **/
public interface AccountService {

    /**
     * Get user information
     * @return
     */
    ApiResponse getAccountInfo();

}
