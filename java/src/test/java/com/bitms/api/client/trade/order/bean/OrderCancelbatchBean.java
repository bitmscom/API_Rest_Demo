package com.bitms.api.client.trade.order.bean;

import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

import java.util.List;

/**
 * @author : yukai
 * @version : 1.0
 * @discription : 多笔撤销bean
 * @create : 2018-07-07-16
 **/
public class OrderCancelbatchBean extends BitmsObject {

    @ApiField("orderIds")
    List<Long> orderIds;

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }
}
