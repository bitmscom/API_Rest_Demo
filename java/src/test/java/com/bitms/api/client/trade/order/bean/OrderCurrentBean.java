package com.bitms.api.client.trade.order.bean;

import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.constant.BitmsConst;
import com.bitms.api.client.mapping.ApiField;

/**
 * @author : yukai
 * @version : 1.0
 * @discription : 当前委托bean
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

    @ApiField("startDate")
    private Long startDate;

    @ApiField("endDate")
    private Long endDate;

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

    public Long getStartDate() {
        return startDate;
    }

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
