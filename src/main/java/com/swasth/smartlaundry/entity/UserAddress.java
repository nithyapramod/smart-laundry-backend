package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_address")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAddress implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4599080958039413761L;

    //@JsonIgnore
    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "house_no")
    private String houseNo;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "address")
    private String address;

    @Column(name = "address_type")
    private String addressType;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lng")
    private String lng;

    @JsonIgnore
    @Column(name = "created_on")
    private Date createdOn;

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

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}
