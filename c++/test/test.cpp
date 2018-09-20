//
// Created by parallels on 9/19/18.
//

#include "TestQuotation.h"
#include "TestTrade.h"
#include "gtest/gtest.h"

TestQuotation quotation("https://api.bitms.com/api/v1/");
TEST(testQuotaion,allticker){
    quotation.QuotationAllTicker();
}
TEST(testQuotaion,ticker){
    quotation.QuotationTicker();
}
TEST(testQuotaion,depth){
    quotation.QuotationDepth();
}
TEST(testQuotaion,trades_detail){
    quotation.QuotationTrades();
}
TEST(testQuotaion,kline){
    quotation.QuotationKline();
}

TestTrade trade("https://api.bitms.com/api/v1/");
TEST(testTrade,common_currency){
    trade.TradeCommonCurrencys();
}
TEST(testTrade,common_symnbol){
    trade.TradeCommonSymbols();
}
TEST(testTrade,common_timestamp){
    trade.TradeCommonTimestamps();
}
TEST(testTrade,account_info){
    trade.TradeAccountInfo();
}
TEST(testTrade,fund_pureSpotAsset){
    trade.TradeFundPurespotasset();
}
TEST(testTrade,fund_futureAccountinfo){
    trade.TradeFundFutureaccountinfo();
}
TEST(testTrade,fund_withdraw){
    trade.TradeFundWithdraw();
}
TEST(testTrade,fund_withdraw_cancel){
    trade.TradeFundWithdrawCancel();
}
TEST(testTrade,fund_withdraw_record){
    trade.TradeFundWithdrawRecords();
}
TEST(testTrade,fund_deposit_record){
    trade.TradeFundDepositRecords();
}
TEST(testTrade,order_orders){
    trade.TradeOrderOrders();
}
TEST(testTrade,order_cancel){
    trade.TradeOrderOrdercancel();
}
TEST(testTrade,order_cancel_batch){
    trade.TradeOrderOrdercancelbatch();
}
TEST(testTrade,order_order_info){
    trade.TradeOrderOrderinfo();
}
TEST(testTrade,order_deal_info){
    trade.TradeOrderDealinfo();
}
TEST(testTrade,order_order_current){
    trade.TradeOrderOrdercurrent();
}
TEST(testTrade,order_order_history){
    trade.TradeOrderOrderhistory();
}
