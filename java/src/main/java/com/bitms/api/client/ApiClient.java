/**
 * bitms.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.bitms.api.client;


import com.bitms.api.client.bean.sign.ApiBasicRequest;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.exception.ApiException;

/**
 * Standard client interface
 */
public interface ApiClient
{
    /**
     * Initiate a regular request
     * @param <T>
     * @param request
     * @return
     * @throws ApiException
     */
    <T extends ApiResponse> T execute(String requestType, ApiBasicRequest<T> request) throws ApiException;

    /**
     * Initiate a request with an authorization code
     * @param request
     * @param authToken
     * @return
     * @throws ApiException
     */
    <T extends ApiResponse> T execute(String requestType, ApiBasicRequest<T> request, String authToken) throws ApiException;
    
}
