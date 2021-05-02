package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class OrderPickUp implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6568623285585403881L;

    private String shopUuid;

    private String orderUuid;

    private Double totalWeight = 0.0;

    private String bagNumber;

    public String getBagNumber() {
        return bagNumber;
    }

    public void setBagNumber(String bagNumber) {
        this.bagNumber = bagNumber;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

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
