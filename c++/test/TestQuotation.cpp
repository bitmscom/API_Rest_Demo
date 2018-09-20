//
// Created by parallels on 9/18/18.
//

#include "TestQuotation.h"

/**
 * get allTicker
 */
void TestQuotation::QuotationAllTicker() {
    url.clear();
    response.clear();
    url=proxy+"allTicker";
    hc.Get(url,response);
    cout<<response<<endl;
}
/**
 * get Ticker
 */
void TestQuotation::QuotationTicker() {
    url.clear();
    response.clear();
    url=proxy+"ticker";
    string strPost="symbol=btc2usd";
    hc.Post(url,strPost,response);
    cout<<response<<endl;
}
/**
 * get Depth
 */
void TestQuotation::QuotationDepth()  {
    url.clear();
    response.clear();
    url=proxy+"depth";
    string strPost="symbol=btc2usd";
    hc.Post(url,strPost,response);
    cout<<response<<endl;
}
/**
 * get Trades Detail
 */
void TestQuotation::QuotationTrades()  {
    url.clear();
    response.clear();
    url=proxy+"trades";
    string strPost="symbol=btc2usd";
    hc.Post(url,strPost,response);
    cout<<response<<endl;
}
/**
 * get Kline
 */
void TestQuotation::QuotationKline()  {
    url.clear();
    response.clear();
    url=proxy+"kline";
    string strPost="type=1m&symbol=btc2usd";
    hc.Post(url,strPost,response);
    cout<<response<<endl;
}
