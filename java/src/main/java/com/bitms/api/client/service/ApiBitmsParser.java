package com.bitms.api.client.service;


import com.bitms.api.client.bean.sign.ApiBasicRequest;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.bean.sign.SignItem;
import com.bitms.api.client.exception.ApiException;

/**
 * 响应解释器接口。响应格式可以是JSON, XML等等。
 * 
 * @author playguy
 * @since 1.0, Apr 11, 2010
 */
public interface ApiBitmsParser<T extends ApiResponse>
{
    /**
     * 把响应字符串解释成相应的领域对象。
     * 
     * @param rsp 响应字符串
     * @return 领域对象
     */
    T parse(String rsp) throws ApiException;
    
    /**
     * 获取响应类类型。
     */
    Class<T> getResponseClass() throws ApiException;
    
    /**
     * 获取响应内的签名数据
     * 
     * @param responseBody 响应字符串
     * @return
     * @throws ApiException
     */
    SignItem getSignItem(ApiBasicRequest<?> request, String responseBody) throws ApiException;
    
    /**
     *  获取实际串：如果是加密内容则返回内容已经是解密后的实际内容了
     * 
     * @param request
     * @param body
     * @param format
     * @param encryptType
     * @param encryptKey
     * @param charset
     * @return
     * @throws ApiException
     */
    String encryptSourceData(ApiBasicRequest<?> request, String body, String format, String encryptType, String encryptKey, String charset) throws ApiException;
}
