package com.bitms.api.client.service.bean;


import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.mapping.ApiField;

/**
 * @version : 1.0
 * @discription : Coin recording bean
 * @create : 2018-07-07-16
 **/
public class WithdrawRecordBean extends BitmsObject {

    @ApiField("currency")
    private String currency;

    @ApiField("page")
    private Integer page = BitmsConst.DEFAULT_CURRENT_PAGE;

    @ApiField("rows")
    private Integer rows = BitmsConst.DEFAULT_PAGE_SIZE;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
