package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class ProRefNumber implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2936751555522170517L;

    private String orderUuid;
    private String refNumber;

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

}
