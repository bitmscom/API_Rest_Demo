package com.bitms.api.client.bean.test;


import com.bitms.api.client.bean.sign.ApiBasicRequest;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.bean.sign.BitmsMap;
import com.bitms.api.client.bean.sign.BitmsObject;

import java.util.Map;

/**
 * Basic request object
 * 
 * @author auto create
 * @since 1.0, 2017-07-20 10:41:44
 */
public class ApiBitmsRequest implements ApiBasicRequest<ApiResponse>
{
    private String      apiVersion  = "1.0";
    
    /**
     * add user-defined text parameters
     */
    private BitmsMap udfParams;

    /**
     * terminal type
     */
    private String      terminalType;
    
    /**
     * Terminal information
     */
    private String      terminalInfo;

    /**
     * Whether to encrypt
     */
    private boolean     needEncrypt = true;
    
    /**
     * Business object
     */
    private BitmsObject bizModel    = null;
    
    /**
     * Request content
     */
    private String      content;
    
    public String getContent()
    {
        return content;
    }
    
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getApiVersion()
    {
        return this.apiVersion;
    }
    
    public void setApiVersion(String apiVersion)
    {
        this.apiVersion = apiVersion;
    }
    
    public void setTerminalType(String terminalType)
    {
        this.terminalType = terminalType;
    }
    
    public String getTerminalType()
    {
        return this.terminalType;
    }
    
    public void setTerminalInfo(String terminalInfo)
    {
        this.terminalInfo = terminalInfo;
    }
    
    public String getTerminalInfo()
    {
        return this.terminalInfo;
    }


    public Map<String, String> getTextParams()
    {
        BitmsMap txtParams = new BitmsMap();
        txtParams.put("content", this.content);
        if (udfParams != null)
        {
            txtParams.putAll(this.udfParams);
        }
        return txtParams;
    }

    public BitmsMap getUdfParams() {
        return udfParams;
    }

    public void setUdfParams(BitmsMap udfParams) {
        this.udfParams = udfParams;
    }

    public Class<ApiResponse> getResponseClass()
    {
        return ApiResponse.class;
    }
    
    public boolean isNeedEncrypt()
    {
        return this.needEncrypt;
    }
    
    public void setNeedEncrypt(boolean needEncrypt)
    {
        this.needEncrypt = needEncrypt;
    }
    
    public BitmsObject getBizModel()
    {
        return this.bizModel;
    }
    
    public void setBizModel(BitmsObject bizModel)
    {
        this.bizModel = bizModel;
    }
}
