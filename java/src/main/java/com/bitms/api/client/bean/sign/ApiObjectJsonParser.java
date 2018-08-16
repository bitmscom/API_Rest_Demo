package com.bitms.api.client.bean.sign;


import com.bitms.api.client.exception.ApiException;
import com.bitms.api.client.mapping.BitmsParser;
import com.bitms.api.client.service.ApiBitmsParser;
import com.bitms.api.client.service.ApiConverter;

/**
 * 单个JSON对象解释器。
 * 
 * @author playguy
 * @since 1.0, Apr 11, 2010
 */
public class ApiObjectJsonParser<T extends ApiResponse> implements ApiBitmsParser<T>
{
    private Class<T> clazz;

    public ApiObjectJsonParser(Class<T> clazz)
    {
        this.clazz = clazz;
    }
    
    public T parse(String rsp) throws ApiException
    {
        ApiConverter converter = new ApiJsonConverter();
        return converter.toResponse(rsp, clazz);
    }
    
    public Class<T> getResponseClass()
    {
        return clazz;
    }
    
    /** 
     * @see BitmsParser#getSignItem(BasicRequest, String)
     */
    public SignItem getSignItem(ApiBasicRequest<?> request, String responseBody) throws ApiException
    {
        ApiConverter converter = new ApiJsonConverter();
        return converter.getSignItem(request, responseBody);
    }
    
    /** 
     * @see BitmsParser#encryptSourceData(BasicRequest, String, String, String, String, String)
     */
    public String encryptSourceData(ApiBasicRequest<?> request, String body, String format, String encryptType, String encryptKey, String charset) throws ApiException
    {
        ApiConverter converter = new ApiJsonConverter();
        return converter.encryptSourceData(request, body, format, encryptType, encryptKey, charset);
    }
}
