/**
 * bitms.com Inc.
 * Copyright (c) 2004-2012 All Rights Reserved.
 */
package com.bitms.api.client;


import com.bitms.api.client.bean.sign.*;
import com.bitms.api.client.constant.BitmsConstants;
import com.bitms.api.client.exception.ApiException;
import com.bitms.api.client.tool.*;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;

/**
 * @version : 1.0
 * @discription : Test transaction interface
 * @create : 2018-07-05-14
 **/
public class DefaultApiClient implements ApiClient {
    private String serverUrl;

    private String privateKey;

    private String format = BitmsConstants.FORMAT_JSON;

    private String sign_type = BitmsConstants.SIGN_TYPE_RSA2;

    private String encryptType = BitmsConstants.ENCRYPT_TYPE_AES;

    private String charset = BitmsConstants.CHARSET_UTF8;

    private String encryptKey;

    private String api_key;

    private int connectTimeout = 3000;

    private int readTimeout = 15000;

    static {
        Security.setProperty("jdk.certpath.disabledAlgorithms", "");
    }

    /**
     * Default constructor
     * @param serverUrl server address
     * @param privateKey private key
     *      
     */
    public DefaultApiClient(String serverUrl, String privateKey) {
        this.serverUrl = serverUrl;
        this.privateKey = privateKey;
    }

    /**
     * Construction method
     */
    public DefaultApiClient(String[] args) {
        this(args[0], args[1]);
        this.encryptKey = args[2];
        this.api_key = args[3];
    }

    /**
     * Initiate a regular request
     *
     * @param request
     * @param <T>
     * @return
     * @throws ApiException
     */
    public <T extends ApiResponse> T execute(String requestType, ApiBasicRequest<T> request) throws ApiException {
        requestType = requestType == null ? "GET" : requestType;
        return execute(requestType, request, null);
    }

    /**
     * Initiate a request with an authorization code
     *
     * @param request
     * @param authToken
     * @param <T>
     * @return
     * @throws ApiException
     */
    public <T extends ApiResponse> T execute(String requestType, ApiBasicRequest<T> request, String authToken) throws ApiException {
        ApiBitmsParser<T> parser = new ApiObjectJsonParser<T>(request.getResponseClass());
        return _execute(request, parser, authToken, requestType);
    }


    /**
     * Assemble interface parameters, handle encryption, signature logic
     *
     * @param request
     * @param authToken
     * @return
     * @throws ApiException
     */
    private <T extends ApiResponse> RequestHolder getRequestHolderWithSign(ApiBasicRequest<?> request, String authToken) throws ApiException {
        RequestHolder requestHolder = new RequestHolder();
        BitmsMap appParams = new BitmsMap(request.getTextParams());
        // Serialize bizModel to fill bizContent only if the API contains the biz_content parameter and the value is empty
        try {
            if (request.getClass().getMethod("getContent") != null && StringUtils.isEmpty(appParams.get(BitmsConstants.CONTENT_KEY)) && request.getBizModel() != null) {
                appParams.put(BitmsConstants.CONTENT_KEY, new JSONWriter().write(request.getBizModel(), true));
            }
        } catch (NoSuchMethodException e) {
            // Can't find getContent, do nothing
        } catch (SecurityException e) {
            BitmsLogger.logBizError(e);
        }
        if (request.isNeedEncrypt()) {// Only new interfaces and setup keys are required to support encryption
            if (!StringUtils.isEmpty(appParams.get(BitmsConstants.CONTENT_KEY))) {
                if (!StringUtils.areNotEmpty(this.encryptKey, this.encryptType)) {// 需要加密必须设置密钥和加密算法
                    throw new ApiException("API requests require encryption, then you must set the key and key type ：encryptKey=" + encryptKey + ",encryptType=" + encryptType);
                }
                String  encryptContent = Encrypt.encryptContent(appParams.get(BitmsConstants.CONTENT_KEY), this.encryptType, this.encryptKey);
                appParams.put(BitmsConstants.CONTENT_KEY, encryptContent);
            }
        }
        if (!StringUtils.isEmpty(authToken)) appParams.put(BitmsConstants.AUTH_TOKEN, authToken);
        requestHolder.setApplicationParams(appParams);// Business request parameter
        if (StringUtils.isEmpty(charset)) charset = BitmsConstants.CHARSET_UTF8;
        BitmsMap protocalMustParams = new BitmsMap();// Public required parameter
        protocalMustParams.put(BitmsConstants.VERSION, request.getApiVersion());
        protocalMustParams.put(BitmsConstants.SIGN_TYPE, this.sign_type);
        protocalMustParams.put(BitmsConstants.TERMINAL_TYPE, request.getTerminalType());
        protocalMustParams.put(BitmsConstants.TERMINAL_INFO, request.getTerminalInfo());
        protocalMustParams.put(BitmsConstants.CHARSET, charset);
        if (request.isNeedEncrypt()) {// Add the encryption type to the required parameters when encrypting
            protocalMustParams.put(BitmsConstants.ENCRYPT_KEY, this.encryptKey);
        }
        protocalMustParams.put(BitmsConstants.TIMESTAMP, System.currentTimeMillis());
        protocalMustParams.put("api_key", api_key);
        requestHolder.setProtocalMustParams(protocalMustParams);
        BitmsMap protocalOptParams = new BitmsMap();// Public optional parameter
        protocalOptParams.put(BitmsConstants.FORMAT, format);
        requestHolder.setProtocalOptParams(protocalOptParams);
        if (!StringUtils.isEmpty(this.sign_type)) {// Add the signature to the public required parameter
            String signContent = Signature.getSignatureContent(requestHolder);
            protocalMustParams.put(BitmsConstants.SIGN, Signature.rsaSign(signContent, privateKey, charset, this.sign_type));
        } else {
            protocalMustParams.put(BitmsConstants.SIGN, "");
        }
        return requestHolder;
    }

    /**
     * Get the base url of the POST request
     *
     * @param requestHolder
     * @return
     * @throws ApiException
     */
    private String getRequestUrl(RequestHolder requestHolder) throws ApiException {
        StringBuffer urlSb = new StringBuffer(serverUrl);
        try {
            String sysMustQuery = WebUtils.buildQuery(requestHolder.getProtocalMustParams(), charset);
            String sysOptQuery = WebUtils.buildQuery(requestHolder.getProtocalOptParams(), charset);
            urlSb.append("?");
            urlSb.append(sysMustQuery);
            if (sysOptQuery != null & sysOptQuery.length() > 0) {
                urlSb.append("&");
                urlSb.append(sysOptQuery);
            }
        } catch (IOException e) {
            throw new ApiException(e);
        }
        return urlSb.toString();
    }

    /**
     * Get jump link in GET mode
     *
     * @param requestHolder
     * @return
     * @throws ApiException
     */
    private String getRedirectUrl(RequestHolder requestHolder) throws ApiException {
        StringBuffer urlSb = new StringBuffer(serverUrl);
        try {
            Map<String, String> sortedMap = Signature.getSortedMap(requestHolder);
            String sortedQuery = WebUtils.buildQuery(sortedMap, charset);
            String sign = requestHolder.getProtocalMustParams().get(BitmsConstants.SIGN);
            urlSb.append("?");
            urlSb.append(sortedQuery);
            if (sign != null & sign.length() > 0) {
                Map<String, String> signMap = new HashMap<String, String>();
                signMap.put(BitmsConstants.SIGN, sign);
                String signQuery = WebUtils.buildQuery(signMap, charset);
                urlSb.append("&");
                urlSb.append(signQuery);
            }
        } catch (IOException e) {
            throw new ApiException(e);
        }
        return urlSb.toString();
    }

    private <T extends ApiResponse> T _execute(ApiBasicRequest<T> request, ApiBitmsParser<T> parser, String authToken, String requestType) throws ApiException {
        Map<String, Object> rt = doPost(request, authToken, requestType);
        if (null == rt) {
            return null;
        }
        T tRsp;
        try {
            ResponseEncryptItem responseItem = encryptResponse(request, rt, parser);
            tRsp = parser.parse(responseItem.getRealContent());
            tRsp = JSONUtils.readValue(responseItem.getRealContent(), new TypeReference<T>(){
            });
            tRsp.setBody(responseItem.getRealContent());
            tRsp.setParams((BitmsMap) rt.get("textParams"));
            return tRsp;
        } catch (RuntimeException e) {
            BitmsLogger.logBizError((String) rt.get("rsp"));
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * POST submission
     *
     * @param request
     * @param authToken
     * @return
     * @throws ApiException
     */
    private <T extends ApiResponse> Map<String, Object> doPost(ApiBasicRequest<T> request, String authToken, String requestType) throws ApiException {
        Map<String, Object> result = new HashMap<String, Object>();
        RequestHolder requestHolder = getRequestHolderWithSign(request, authToken);
        String url = getRequestUrl(requestHolder);
        BitmsLogger.logBizDebug(getRedirectUrl(requestHolder));
        String rsp = "";
        try {
            if (request instanceof ApiUploadRequest) {
                ApiUploadRequest<T> uRequest = (ApiUploadRequest<T>) request;
                Map<String, FileItem> fileParams = BitmsUtils.cleanupMap(uRequest.getFileParams());
                rsp = WebUtils.doPost(url, requestHolder.getApplicationParams(), fileParams, charset, connectTimeout, readTimeout);
            } else {
                if (requestType.equalsIgnoreCase("POST"))
                    rsp = WebUtils.doPost(url, requestHolder.getApplicationParams(), charset, connectTimeout, readTimeout);
                if (requestType.equalsIgnoreCase("GET"))
                    rsp = WebUtils.doGet(url, requestHolder.getApplicationParams(), charset, connectTimeout, readTimeout);
            }
        } catch (IOException e) {
            throw new ApiException(e);
        }
        result.put("rsp", rsp);
        result.put("textParams", requestHolder.getApplicationParams());
        result.put("protocalMustParams", requestHolder.getProtocalMustParams());
        result.put("protocalOptParams", requestHolder.getProtocalOptParams());
        result.put("url", url);
        return result;
    }

    /**
     * Decrypt response
     *
     * @param request
     * @param rt
     * @param parser
     * @return
     * @throws ApiException
     */
    private <T extends ApiResponse> ResponseEncryptItem encryptResponse(ApiBasicRequest<T> request, Map<String, Object> rt, ApiBitmsParser<T> parser) throws ApiException {
        String responseBody = (String) rt.get("rsp");
        String realBody;
        if (request.isNeedEncrypt() && !responseBody.contains("err-code") && !responseBody.contains("err-msg")) {
            realBody = parser.encryptSourceData(request, responseBody, this.format, this.encryptType, this.encryptKey, this.charset);
        } else {
            realBody = (String) rt.get("rsp");
        }
        return new ResponseEncryptItem(responseBody, realBody);
    }
}
