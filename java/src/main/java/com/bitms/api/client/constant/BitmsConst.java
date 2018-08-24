/*
 * @(#)ZttxConst.java 2015-4-14 下午2:02:23
 * Copyright 2015, Inc. All rights reserved. com.bitms
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.bitms.api.client.constant;

import com.bitms.api.client.tool.PropertiesUtils;

/**
 * <p>File：BitmsConst.java</p>
 * <p>Title: </p>
 * <p>Description:</p>
 * <p>Copyright: Copyright (c) 2015 2015-4-14 下午2:02:23</p>
 * <p>Company: bitms</p>
 *
 * @version 1.0
 */
public class BitmsConst
{

    public static final PropertiesUtils properties = new PropertiesUtils("bitms.properties");

    private BitmsConst()
    {// Prevent instantiation
    }
    
    /**
     * The current page
     */
    public static final Integer  DEFAULT_CURRENT_PAGE          = 1;
    
    /**
     * Paging Size
     */
    public static final Integer  DEFAULT_PAGE_SIZE             = 10;

    public static String ROOT = properties.getProperty("api.root");

    //Bitms
    public static String APIKEY = properties.getProperty("api.apiKey");
    //private key
    public static String PRIKEY = properties.getProperty("api.priKey");

}
