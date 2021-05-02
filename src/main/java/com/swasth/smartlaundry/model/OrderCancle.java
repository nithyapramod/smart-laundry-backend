package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class OrderCancle implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6568623285585403881L;

    private String shopUuid;

    private String orderUuid;

    private String reason;

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

}
