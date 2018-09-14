package com.bitms.api.client.service;

import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.service.bean.*;

/**
 * @version : 1.0
 * @program : com.bitms.api.rest.service
 * @discription : Fund Service
 * @create : 2018-08-20-13
 **/
public interface FundService {

    /**
     * Get Pure Spot Account
     *
     * @param data
     * @return
     */
    ApiResponse getPureSpotAsset(PureSpotBean data);

    /**
     * Leverage account information
     *
     * @param data
     * @return
     */
    ApiResponse getLeveragedAccountInfo(LeveragedSpotBean data);

    /**
     * Coin withdrawal request
     *
     * @param data
     * @return
     */
    ApiResponse withdrawBitms(WithdrawBean data);

    /**
     * Coin cancellation
     *
     * @param data
     * @return
     */
    ApiResponse withdrawCancel(WithdrawCancelBean data);

    /**
     * Cash withdrawal record
     *
     * @param data
     * @return
     */
    ApiResponse withdrawRecords(WithdrawRecordBean data);

    /**
     * Recharge record
     *
     * @param data
     * @return
     */
    ApiResponse depositRecords(WithdrawRecordBean data);

}
