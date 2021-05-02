package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "shop_order_grid")
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderGrid implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3648147766128539106L;

    //@JsonIgnore
    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "total_orders")
    private int totalOrders = 0;

    @Column(name = "ongoing_orders")
    private int ongoingOrders = 0;

    @Column(name = "completed_orders")
    private int completedOrders = 0;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    @Transient
    private ShopOrderHistory latestOrder = new ShopOrderHistory();

    @Column(name = "total_revenue")
    private Double totalRevenue = 0.0;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public int getTotalOrders() {
        return totalOrders;
    }

    public void setTotalOrders(int totalOrders) {
        this.totalOrders = totalOrders;
    }

    public int getOngoingOrders() {
        return ongoingOrders;
    }

    public void setOngoingOrders(int ongoingOrders) {
        this.ongoingOrders = ongoingOrders;
    }

    public int getCompletedOrders() {
        return completedOrders;
    }

    public void setCompletedOrders(int completedOrders) {
        this.completedOrders = completedOrders;
    }

    public ShopOrderHistory getLatestOrder() {
        return latestOrder;
    }

    public void setLatestOrder(ShopOrderHistory latestOrder) {
        this.latestOrder = latestOrder;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }


    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

}
