package com.bitms.api.client.bean.sign;

/**
 * Request parameter header file
 */
public class RequestHolder
{
    /**
     * Public required parameter
     */
    private BitmsMap protocalMustParams;
    
    /**
     * Public optional parameter
     */
    private BitmsMap protocalOptParams;
    
    /**
     * Business request parameter
     */
    private BitmsMap applicationParams;
    
    public BitmsMap getProtocalMustParams()
    {
        return protocalMustParams;
    }
    
    public void setProtocalMustParams(BitmsMap protocalMustParams)
    {
        this.protocalMustParams = protocalMustParams;
    }
    
    public BitmsMap getProtocalOptParams()
    {
        return protocalOptParams;
    }
    
    public void setProtocalOptParams(BitmsMap protocalOptParams)
    {
        this.protocalOptParams = protocalOptParams;
    }
    
    public BitmsMap getApplicationParams()
    {
        return applicationParams;
    }
    
    public void setApplicationParams(BitmsMap applicationParams)
    {
        this.applicationParams = applicationParams;
    }
}
