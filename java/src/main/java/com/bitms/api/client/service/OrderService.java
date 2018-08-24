package com.bitms.api.client.service;

import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.service.bean.*;

/**
 * @version : 1.0
 * @program : com.bitms.api.client.service
 * @discription : order service
 * @create : 2018-08-20-14
 **/
public interface OrderService {

    /**
     * Single order
     * @param data
     * @return
     */
    ApiResponse doMatchRequest(EntrustBean data);

    /**
     * Transaction cancellation (single stroke)
     * @param data
     * @return
     */
    ApiResponse doMatchCancelRequest(EntrustCancelBean data);

    /**
     * Transaction cancellation (multiple)
     * @param data
     * @return
     */
    ApiResponse doMatchCancelBatchRequest(OrderCancelbatchBean data);

    /**
     * Query order details
     * @param data
     * @return
     */
    ApiResponse searchOrderInfo(OrderInfoBean data);

    /**
     * Query order transaction details
     * @param data
     * @return
     */
    ApiResponse searchDealInfo(OrderInfoBean data);

    /**
     * Current delegation list
     * @param data
     * @return
     */
    ApiResponse entrustxOnDoingRequest(OrderCurrentBean data);

    /**
     * Historical delegation list
     * @param data
     * @return
     */
    ApiResponse testDoMatchRequest(OrderCurrentBean data);
}
