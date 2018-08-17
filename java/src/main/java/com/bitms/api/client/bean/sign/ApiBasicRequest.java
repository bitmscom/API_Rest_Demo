package com.bitms.api.client.bean.sign;

import java.util.Map;

public interface ApiBasicRequest<T extends ApiResponse> {
    /**
      * Get all the set of text request parameters in the form of Key-Value. among them:
      * <ul>
      * <li>Key: Request parameter name</li>
      * <li>Value: request parameter value</li>
      * </ul>
      *
      * @return text request parameter set
      */
    Map<String, String> getTextParams();

    /**
      * Get the version of the current interface
      *
      * @return API version
      */
    String getApiVersion();

    /**
      * Get terminal type
      *
      * @return terminal type
      */
    String getTerminalType();

    /**
      * Get terminal information
      *
      * @return terminal information
      */
    String getTerminalInfo();

    /**
      * Get the response type of the current API
      *
      * @return response type
      */
    Class<T> getResponseClass();

    /**
      * Determine if encryption is required
      *
      * @return
      */
    boolean isNeedEncrypt();

    /**
      * Set whether the request requires encryption
      *
      * @param needEncrypt
      */
    void setNeedEncrypt(boolean needEncrypt);

    /**
      * Get business entity
      * @return
      */
    BitmsObject getBizModel();

    /**
      * Set the business entity, if you want to use this method, please do not set biz_content directly
      *
      * @param bizModel
      */
    void setBizModel(BitmsObject bizModel);
}
