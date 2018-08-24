package com.bitms.api.client.service.bean;

import com.bitms.api.client.bean.sign.BitmsObject;
import com.bitms.api.client.mapping.ApiField;

import java.util.List;

/**
 * @version : 1.0
 * @discription : Multiple undo beans
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
