package com.bitms.api.client.bean.resp.account;

/**
 * @version : 1.0
 * @discription : Returned user information
 * @create : 2018-07-03-19
 **/
public class AccountResponse {

    private String accountName;

    private String lang;

    private String accountStatus;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
}
