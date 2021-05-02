package com.swasth.smartlaundry.model;

import java.io.Serializable;
import java.util.Date;

public class OrderAssign implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6568623285585403881L;

    private String empUuid;

    private String orderUuid;

    /**
     * 1.assign order to delivery boy
     * 2.change the delivery boy
     */
    private int orderType;


    private Date deliveryDate;

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getEmpUuid() {
        return empUuid;
    }

    public void setEmpUuid(String empUuid) {
        this.empUuid = empUuid;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public int getOrderType() {
        return orderType;
    }

    public void setOrderType(int orderType) {
        this.orderType = orderType;
    }

}
