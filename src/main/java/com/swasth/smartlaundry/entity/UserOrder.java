package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_order")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserOrder implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3994594455106646841L;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "user_address_uuid")
    private String userAddressUuid;

    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "slot_time")
    private String slotTime;

    @Column(name = "assign_on")
    private Date assignOn;

    @Column(name = "order_on")
    private Date orderOn;

    @Column(name = "cancel_on")
    private Date cancelOn;

    @Column(name = "pickup_on")
    private Date pickupOn;

    @Column(name = "total_weight")
    private Double totalWeight = 0.0;

    @Column(name = "bag_number")
    private String bagNumber;

    @Column(name = "delivery_on")
    private Date deliveryOn;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "status")
    private String status;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "ref_number")
    private String refNumber;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public String getUserAddressUuid() {
        return userAddressUuid;
    }

    public void setUserAddressUuid(String userAddressUuid) {
        this.userAddressUuid = userAddressUuid;
    }

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public String getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(String slotTime) {
        this.slotTime = slotTime;
    }

    public Date getAssignOn() {
        return assignOn;
    }

    public void setAssignOn(Date assignOn) {
        this.assignOn = assignOn;
    }

    public Date getOrderOn() {
        return orderOn;
    }

    public void setOrderOn(Date orderOn) {
        this.orderOn = orderOn;
    }

    public Date getPickupOn() {
        return pickupOn;
    }

    public void setPickupOn(Date pickupOn) {
        this.pickupOn = pickupOn;
    }

    public Date getDeliveryOn() {
        return deliveryOn;
    }

    public void setDeliveryOn(Date deliveryOn) {
        this.deliveryOn = deliveryOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getCancelOn() {
        return cancelOn;
    }

    public void setCancelOn(Date cancelOn) {
        this.cancelOn = cancelOn;
    }

    public Double getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(Double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getBagNumber() {
        return bagNumber;
    }

    public void setBagNumber(String bagNumber) {
        this.bagNumber = bagNumber;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }


}
