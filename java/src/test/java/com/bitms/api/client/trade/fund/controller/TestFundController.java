package com.bitms.api.client.trade.fund.controller;

import com.bitms.api.client.ApiClient;
import com.bitms.api.client.DefaultApiClient;
import com.bitms.api.client.bean.sign.ApiResponse;
import com.bitms.api.client.bean.test.ApiBitmsRequest;
import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.constant.BitmsConstants;
import com.bitms.api.client.tool.WebUtils;
import com.bitms.api.client.trade.account.bean.UserInfoTest;
import com.bitms.api.client.trade.fund.bean.*;
import org.junit.Test;

/**
 * @author : yukai
 * @version : 1.0
 * @discription : 资产测试类
 * @create : 2018-07-07-14
 **/
public class TestFundController{

    private String root = BitmsConst.ROOT;

    //Bitms
    private String apiKey = BitmsConst.apiKey;
    //加签私钥
    private String priKey = BitmsConst.priKey;
    /**
     * 纯正现货账户   200
     *
     * @throws Exception
     */
    @Test
    public void testGetPureSpotAsset() throws Exception {
        String[] data1 = {root + "fund/pureSpotAsset", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        PureSpotBean data = new PureSpotBean();
        data.setSymbol("btc2usd");
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }

    /**
     * 杠杆现货账户   200
     *
     * @throws Exception
     */
    @Test
    public void testGetLeveragedSpotAsset() throws Exception {
        String[] data1 = {root + "fund/leveragedSpotAsset", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        LeveragedSpotBean data = new LeveragedSpotBean();
        data.setSymbol("btc2usd");
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }

    /**
     * 杠杆账户信息   200
     *
     * @throws Exception
     */
    @Test
    public void testGetLeveragedAccountInfo() throws Exception {
        String[] data1 = {root + "fund/leveragedAccountInfo", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        LeveragedSpotBean data = new LeveragedSpotBean();
        data.setSymbol("btc2usd");
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }

    /**
     * 提币提现申请   bitms
     *
     * @throws Exception
     */
    @Test
    public void testWithdrawBitms() throws Exception {
        String[] data1 = {root + "fund/withdraw", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        WithdrawBean data = new WithdrawBean();
        data.setAddress("1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa");
        data.setAmount("0.01");
        data.setCurrency("btc");
        data.setFundPwd("963852");
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        System.out.println(response.getBody());
    }

    /**
     * 提币取消 200
     *
     * @throws Exception
     */
    @Test
    public void testWithdrawCancel() throws Exception {
        String[] data1 = {root + "fund/withdraw_cancel", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        WithdrawCancelBean data = new WithdrawCancelBean();
        data.setWithdrawId(120748699621003264l);
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_POST, request);
        System.out.println(response.getBody());
    }

    /**
     * 提币提现记录   200
     *
     * @throws Exception
     */
    @Test
    public void testWithdrawRecords() throws Exception {
        String[] data1 = {root + "fund/withdraw_records", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        WithdrawRecordBean data = new WithdrawRecordBean();
        data.setCurrency("btc");
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }

    /**
     * 充值记录 200
     *
     * @throws Exception
     */
    @Test
    public void testDepositRecords() throws Exception {
        String[] data1 = {root + "fund/deposit_records", priKey, "123456789", apiKey};
        ApiClient client = new DefaultApiClient(data1);
        ApiBitmsRequest request = new ApiBitmsRequest();
        request.setNeedEncrypt(true);
        WithdrawRecordBean data = new WithdrawRecordBean();
        data.setCurrency("btc");
        request.setBizModel(data);
        ApiResponse response = client.execute(BitmsConstants.METHOD_GET, request);
        System.out.println(response.getBody());
    }


}
