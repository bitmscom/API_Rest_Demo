//
// Created by parallels on 9/18/18.
//

#ifndef UNTITLED1_TESTTRADE_H
#define UNTITLED1_TESTTRADE_H

#include <iostream>
#include <string>
#include "../tool/curl/httpclient.h"
#include "../tool/cryptor/AES-base64.h"
#include "../tool/json/JsonOperator.h"

class TestTrade {
private:
    string proxy="http://api.bitms.com/api/v1";
    JsonOperator js;
    CHttpClient hc;
    string url;
    string response;
    map<string,string> params;
public:
    TestTrade(){};
    TestTrade(string proxy){
        this->proxy.clear();
        this->proxy=proxy;
    }

public:
    /*common request*/
    /**
     * Common Currencys
     */
    void TradeCommonCurrencys();
    /**
     * Common Symbols
     */
    void TradeCommonSymbols();
    /**
     * Common Timestamps
     */
    void TradeCommonTimestamps();

    /*Account Request*/
    /**
     * Account Info
     */
    void TradeAccountInfo();

    /*Fund Request*/
    /**
     * Fund pureSpotAsset
     */
    void TradeFundPurespotasset();
    /**
     * Fund futureAccountInfo
     */
    void TradeFundFutureaccountinfo();
    /**
     * Fund Withdraw
     */
    void TradeFundWithdraw();
    /**
     * Fund Withdraw_cancel
     */
    void TradeFundWithdrawCancel();
    /**
     * Fund Withdraw_records
     */
    void TradeFundWithdrawRecords();
    /**
     * Fund deposit_records
     */
    void TradeFundDepositRecords();

    /*Trade Request*/
    /**
     * Order orders
     */
    void TradeOrderOrders();
    /**
     * Order order_cancel
     */
    void TradeOrderOrdercancel();
    /**
     * Order order_cancel_batch
     */
    void TradeOrderOrdercancelbatch();
    /**
     * Order order_info
     */
    void TradeOrderOrderinfo();
    /**
     * Order order_dealinfo
     */
    void TradeOrderDealinfo();
    /**
     * Order order_current
     */
    void TradeOrderOrdercurrent();
    /**
     * Order order_history
     */
    void TradeOrderOrderhistory();





};


#endif //UNTITLED1_TESTTRADE_H
