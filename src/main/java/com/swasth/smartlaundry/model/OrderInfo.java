package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class OrderInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6568623285585403881L;

    private String shopUuid;

    private String orderUuid;


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


}
