package com.swasth.smartlaundry.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.swasth.smartlaundry.entity.OrderItems;

public class OrderItemsInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 2353395311573472200L;

    private Double orderValue;
    private Integer qtyValue;

    private List<OrderItems> orderItems = new ArrayList<OrderItems>();

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public Integer getQtyValue() {
        return qtyValue;
    }

    public void setQtyValue(Integer qtyValue) {
        this.qtyValue = qtyValue;
    }

}
