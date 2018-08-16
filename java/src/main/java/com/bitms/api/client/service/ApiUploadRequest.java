package com.bitms.api.client.service;

import com.bitms.api.client.bean.sign.ApiBasicRequest;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.bean.sign.FileItem;

import java.util.Map;

/**
 * 上传请求接口，支持同时上传多个文件。
 * 
 * @author playguy
 * @since 1.0, Sep 12, 2009
 */
public interface ApiUploadRequest<T extends ApiResponse> extends ApiBasicRequest<T>
{
    /**
     * 获取所有的Key-Value形式的文件请求参数集合。其中：
     * <ul>
     * <li>Key: 请求参数名</li>
     * <li>Value: 请求参数文件元数据</li>
     * </ul>
     * 
     * @return 文件请求参数集合
     */
    Map<String, FileItem> getFileParams();
}
