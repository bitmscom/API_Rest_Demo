package com.bitms.api.client.bean.resp.order;

/**
 * @version : 1.0
 * @discription : Multiple revocations
 * @create : 2018-07-04-15
 **/
public class OrderCancelResponse {

    private String result;

    private Long orderId;

    private String errorMsg;

    private Integer errorCode;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
