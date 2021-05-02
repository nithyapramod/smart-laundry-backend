package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderHistory implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 847061276063827134L;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "slot_time")
    private String slotTime;

    @Column(name = "assign_on")
    private Date assignOn;

    @Column(name = "cancel_on")
    private Date cancelOn;

    @Column(name = "pickup_on")
    private Date pickupOn;

    @Column(name = "order_on")
    private Date orderOn;

    @Column(name = "delivery_on")
    private Date deliveryOn;

    @Column(name = "status")
    private String orderStatus;

    @Column(name = "bag_number")
    private String bagNumber;


    @Column(name = "ord_id")
    private int ordId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public Date getPickupOn() {
        return pickupOn;
    }

    public void setPickupOn(Date pickupOn) {
        this.pickupOn = pickupOn;
    }

    public Date getOrderOn() {
        return orderOn;
    }

    public void setOrderOn(Date orderOn) {
        this.orderOn = orderOn;
    }

    public Date getDeliveryOn() {
        return deliveryOn;
    }

    public void setDeliveryOn(Date deliveryOn) {
        this.deliveryOn = deliveryOn;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getAssignOn() {
        return assignOn;
    }

    public void setAssignOn(Date assignOn) {
        this.assignOn = assignOn;
    }

    public int getOrdId() {
        return ordId;
    }

    public void setOrdId(int ordId) {
        this.ordId = ordId;
    }

    public Date getCancelOn() {
        return cancelOn;
    }

    public void setCancelOn(Date cancelOn) {
        this.cancelOn = cancelOn;
    }

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public String getBagNumber() {
        return bagNumber;
    }

    public void setBagNumber(String bagNumber) {
        this.bagNumber = bagNumber;
    }

}
