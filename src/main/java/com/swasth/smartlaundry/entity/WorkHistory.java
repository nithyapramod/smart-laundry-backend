package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkHistory implements Serializable {

    private static final long serialVersionUID = 5147667078949301252L;

    @JsonIgnore
    @Id
    @Column(name = "uuid")
    private String uuid;


    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "shop_name")
    private String shopName;

    @JsonProperty("shopStatus")
    @Column(name = "status")
    private String status;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "total_orders")
    private int totalOrders;

    @Column(name = "ongoing_orders")
    private int ongoingOrders;

    @Column(name = "completed_orders")
    private int completedOrders;

    @Column(name = "cancel_orders")
    private int cancelOrders;

    @Column(name = "total_revenue")
    private Double totalRevenue;

    @Column(name = "created_on")
    private Date revenueOn;

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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public int getCancelOrders() {
        return cancelOrders;
    }

    public void setCancelOrders(int cancelOrders) {
        this.cancelOrders = cancelOrders;
    }

    public Double getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(Double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Date getRevenueOn() {
        return revenueOn;
    }

    public void setRevenueOn(Date revenueOn) {
        this.revenueOn = revenueOn;
    }


}
