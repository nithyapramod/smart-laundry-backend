package com.swasth.smartlaundry.model;

import java.io.Serializable;
import java.util.List;

import com.swasth.smartlaundry.entity.OrderHistory;
import com.swasth.smartlaundry.entity.OrderItems;
import com.swasth.smartlaundry.entity.OrderTransaction;
import com.swasth.smartlaundry.entity.ShopOrderHistory;

public class OrderInfoDeatil implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4201494975189367179L;

    private List<OrderItems> orderItems = null;

    private ShopOrderHistory orderDeatil = null;

    private OrderHistory userOrderDeatil = null;

    private Double orderValue = 0.0;

    private Integer orderQtyValue = 0;

    private Integer orderQty = 0;

    private OrderTransaction orderTransaction = null;

    public OrderHistory getUserOrderDeatil() {
        return userOrderDeatil;
    }

    public void setUserOrderDeatil(OrderHistory userOrderDeatil) {
        this.userOrderDeatil = userOrderDeatil;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public ShopOrderHistory getOrderDeatil() {
        return orderDeatil;
    }

    public void setOrderDeatil(ShopOrderHistory orderDeatil) {
        this.orderDeatil = orderDeatil;
    }

    public Double getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(Double orderValue) {
        this.orderValue = orderValue;
    }

    public Integer getOrderQtyValue() {
        return orderQtyValue;
    }

    public void setOrderQtyValue(Integer orderQtyValue) {
        this.orderQtyValue = orderQtyValue;
    }

    public Integer getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(Integer orderQty) {
        this.orderQty = orderQty;
    }

    public OrderTransaction getOrderTransaction() {
        return orderTransaction;
    }

    public void setOrderTransaction(OrderTransaction orderTransaction) {
        this.orderTransaction = orderTransaction;
    }

}
