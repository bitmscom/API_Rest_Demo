package com.bitms.api.client.bean.resp.fund;

import java.math.BigDecimal;

/**
 * @version : 1.0
 * @discription : Withdrawal record
 * @create : 2018-07-16-09
 **/
public class WithdrawRecordResponse {

    private String txHash;

    private BigDecimal amount;

    private Object address;

    private BigDecimal fee;

    private String state;

    private String createTime;

    public String getTxHash() {
        return txHash;
    }

    public void setTxHash(String txHash) {
        this.txHash = txHash;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "WithdrawRecordResponse{" +
                "txHash='" + txHash + '\'' +
                ", amount=" + amount +
                ", address=" + address +
                ", fee=" + fee +
                ", state='" + state + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
