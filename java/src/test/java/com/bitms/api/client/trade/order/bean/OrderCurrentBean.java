package com.bitms.api.client.trade.order.bean;

import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.mapping.ApiField;

/**
 * @version : 1.0
 * @discription : Current delegate bean
 * @create : 2018-07-07-17
 **/
public class OrderCurrentBean extends BitmsObject {

    @ApiField("symbol")
    private String symbol;

    @ApiField("page")
    private Integer page;

    @ApiField("rows")
    private Integer rows;

    @ApiField("type")
    private String type;

    @ApiField("direct")
    private String direct;

    @ApiField("state")
    private String state;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
