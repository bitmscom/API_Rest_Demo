//
// Created by parallels on 9/18/18.
//

#include "TestTrade.h"
/**
 * get Common Currency
 */
void TestTrade::TradeCommonCurrencys() {
    url.clear();
    response.clear();
    url=proxy+"common/currencys";
    hc.Get(url,response);
    cout<<response<<endl;
}

void TestTrade::TradeCommonSymbols()  {
    url.clear();
    response.clear();
    url=proxy+"common/symbols";
    hc.Get(url,response);
    cout<<response<<endl;
}

void TestTrade::TradeCommonTimestamps()  {
    url.clear();
    response.clear();
    url=proxy+"common/timestamp";
    hc.Get(url,response);
    cout<<response<<endl;
}
void TestTrade::TradeAccountInfo() {
    url.clear();
    url=proxy+"account/info";
    response.clear();
    hc.Get_crypt(url,response);
    std::cout<<response<<std::endl;
}


void TestTrade::TradeFundPurespotasset() {
    url.clear();
    url=proxy+"fund/pureSpotAsset";
    response.clear();
    hc.Get_crypt(url,response);
    std::cout<<response<<std::endl;
}

void TestTrade::TradeFundFutureaccountinfo()  {
    url.clear();
    url=proxy+"fund/futureAccountInfo";
    response.clear();
    hc.Get_crypt(url,response);
    std::cout<<response<<std::endl;
}

void TestTrade::TradeFundWithdraw()   {
    url.clear();
    url=proxy+"fund/withdraw";
    response.clear();
    params.clear();
    params["address"]="16B8QrLvB74A7RxftziPpySqR9zrtVMaoq";
    params["currency"]="btc";
    params["amount"]="0.01";
    params["fundPwd"]="123456";//your fund password
    if(hc.Post_crypt(url,js.general_content(params),response))
        cout<<response<<endl;
}

void TestTrade::TradeFundWithdrawCancel()    {
    url.clear();
    url=proxy+"fund/withdraw_cancel";
    response.clear();
    params.clear();
    params["withdrawId"]="136651687149580288";
    if(hc.Post_crypt(url,js.general_content(params),response))
        cout<<response<<endl;
}

void TestTrade::TradeFundWithdrawRecords() {
    url.clear();
    url=proxy+"fund/withdraw_records";
    response.clear();
    params.clear();
    params["currency"]="btc";
   // params["page"]="1";
   // params["row"]="10";
    if(hc.Get_crypt(url,response,js.general_content(params)));
        cout<<response<<endl;
}
void TestTrade::TradeFundDepositRecords() {
    url.clear();
    url=proxy+"fund/deposit_records";
    response.clear();
    params.clear();
    params["currency"]="btc";
    // params["page"]="1";
    // params["row"]="10";
    if(hc.Get_crypt(url,response,js.general_content(params)));
    cout<<response<<endl;
}
void TestTrade::TradeOrderOrders() {
    url.clear();
    url=proxy+"order/orders";
    response.clear();
    params.clear();
    params["symbol"]="btc2usd";
    params["type"]="limit";
    params["direct"]="sell";
    params["amount"]="1";
    params["price"]="7000";
    if(hc.Post_crypt(url,js.general_content(params),response));
    cout<<response<<endl;
}
void TestTrade::TradeOrderOrdercancel() {
    url.clear();
    url=proxy+"order/order_cancel";
    response.clear();
    params.clear();
    params["orderId"]="136661648659329024";
    if(hc.Post_crypt(url,js.general_content(params),response));
    cout<<response<<endl;
}
void TestTrade::TradeOrderOrdercancelbatch() {
    url.clear();
    url=proxy+"order/order_cancel_batch";
    response.clear();
    vector<string> orderids;
    map<string,vector<string>> param;
    orderids.push_back("136664633221197824");
    orderids.push_back("136664822875041792");
    orderids.push_back("136664881276530688");
    param["orderIds"]=orderids;
    if(hc.Post_crypt(url,js.general_content1(param),response))
        cout<<response<<endl;
}
void TestTrade::TradeOrderOrderinfo() {
    url.clear();
    url=proxy+"order/order_info";
    response.clear();
    params.clear();
    params["orderId"]="136664881276530688";
    if(hc.Get_crypt(url,response,js.general_content(params)));
    cout<<response<<endl;
}
void TestTrade::TradeOrderDealinfo() {
    url.clear();
    url=proxy+"order/deal_info";
    response.clear();
    params.clear();
    params["orderId"]="136664881276530688";
    if(hc.Get_crypt(url,response,js.general_content(params)));
    cout<<response<<endl;
}
void TestTrade::TradeOrderOrdercurrent() {
    url.clear();
    url=proxy+"order/order_current";
    response.clear();
    params.clear();
    params["symbol"]="btc2usd";
    if(hc.Get_crypt(url,response,js.general_content(params)));
    cout<<response<<endl;
}
void TestTrade::TradeOrderOrderhistory()  {
    url.clear();
    url=proxy+"order/order_history";
    response.clear();
    params.clear();
    params["symbol"]="btc2usd";
    if(hc.Get_crypt(url,response,js.general_content(params)));
    cout<<response<<endl;
}