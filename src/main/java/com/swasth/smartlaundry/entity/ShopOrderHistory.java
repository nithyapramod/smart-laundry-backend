package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopOrderHistory implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 847061276063827134L;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "first_name")
    private String customerName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "address")
    private String address;

    @Column(name = "slot_time")
    private String slotTime;

    @Column(name = "assign_on")
    private Date assignOn;

    @Column(name = "pickup_on")
    private Date pickupOn;

    @Column(name = "order_on")
    private Date orderOn;

    @Column(name = "delivery_on")
    private Date deliveryOn;

    @Column(name = "status")
    private String orderStatus;

    @Column(name = "ord_id")
    private Integer ordId;

    @Column(name = "cancel_on")
    private Date cancelOn;

    @Column(name = "bag_number")
    private String bagNumber;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
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

    public Integer getOrdId() {
        return ordId;
    }

    public void setOrdId(Integer ordId) {
        this.ordId = ordId;
    }

    public Date getCancelOn() {
        return cancelOn;
    }

    public void setCancelOn(Date cancelOn) {
        this.cancelOn = cancelOn;
    }

    public String getBagNumber() {
        return bagNumber;
    }

    public void setBagNumber(String bagNumber) {
        this.bagNumber = bagNumber;
    }


}
