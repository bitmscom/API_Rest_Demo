//
// Created by parallels on 9/18/18.
//

#ifndef UNTITLED1_TESTQUTATION_H
#define UNTITLED1_TESTQUTATION_H

#include <iostream>
#include <string>
#include "../tool/curl/httpclient.h"
#include "../tool/json/JsonOperator.h"


/**
 * Quotation Test
 */
class TestQuotation {
private:
    string proxy="http://api.bitms.com/api/v1/";
    CHttpClient hc;
    string url;
    string response;
public:
    TestQuotation(){
    }
    TestQuotation(const string proxy){
        this->proxy.clear();
        this->proxy=proxy;
    }
public:
    /**
     * Test get allTicker
     */
    void QuotationAllTicker();
    /**
     * Test get Tikcer
     */
    void QuotationTicker();
    /**
     * Test get Depth
     */
    void QuotationDepth();
    /**
     * Test get Trades
     */
    void QuotationTrades();
    /**
     * Test get Kline
     */
    void QuotationKline();
};


#endif //UNTITLED1_TESTQUTATION_H
