package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "shop_verification")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShopVerification implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 9050745361428175517L;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "admin_uuid")
    private String adminUuid;

    @Column(name = "shop_name")
    private String shopName;

    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "shop_phone_number")
    private String shopPhoneNumber;


    @Column(name = "remarks")
    private String remarks;

    @Column(name = "shop_address")
    private String shopAddress;

    @Column(name = "status")
    private String shStatus;

    @Column(name = "created_on")
    private Date createdOn = new Date();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAdminUuid() {
        return adminUuid;
    }

    public void setAdminUuid(String adminUuid) {
        this.adminUuid = adminUuid;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public String getShopPhoneNumber() {
        return shopPhoneNumber;
    }

    public void setShopPhoneNumber(String shopPhoneNumber) {
        this.shopPhoneNumber = shopPhoneNumber;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }


    public String getShStatus() {
        return shStatus;
    }

    public void setShStatus(String shStatus) {
        this.shStatus = shStatus;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}
