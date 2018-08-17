package com.bitms.api.client.mapping;


import com.bitms.api.client.bean.sign.BasicRequest;
import com.bitms.api.client.bean.sign.BitmsResponse;
import com.bitms.api.client.bean.sign.SignItem;
import com.bitms.api.client.exception.ApiException;

/**
  * Response interpreter interface. The response format can be JSON, XML, and so on.
  *
  * @author playguy
  * @since 1.0, Apr 11, 2010
  */
public interface BitmsParser<T extends BitmsResponse>
{
    /**
      * Interpret the response string as the corresponding domain object.
      *
      * @param rsp response string
      * @return domain object
      */
    T parse(String rsp) throws ApiException;

    /**
      * Get the response class type.
      */
    Class<T> getResponseClass() throws ApiException;

    /**
      * Get the signature data in the response
      *
      * @param responseBody response string
      * @return
      * @throws ApiException
      */
    SignItem getSignItem(BasicRequest<?> request, String responseBody) throws ApiException;

    /**
      * Get the actual string: If it is encrypted content, the returned content is already the actual content after decryption.
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
    String encryptSourceData(BasicRequest<?> request, String body, String format, String encryptType, String encryptKey, String charset) throws ApiException;
}
