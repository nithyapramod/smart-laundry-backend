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
@Table(name = "item_pricing")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPricing implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5621356413502709617L;

    @Id
    @Column(name = "uuid")
    private String ipmUuid;

    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "items_category_uuid")
    private String itemsCategoryUuid;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "price")
    private Integer price;

    @JsonIgnore
    @Column(name = "status")
    private String status = "A";

    @Column(name = "created_on")
    private Date createdOn = new Date();

    public String getIpmUuid() {
        return ipmUuid;
    }

    public void setIpmUuid(String ipmUuid) {
        this.ipmUuid = ipmUuid;
    }

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public String getItemsCategoryUuid() {
        return itemsCategoryUuid;
    }

    public void setItemsCategoryUuid(String itemsCategoryUuid) {
        this.itemsCategoryUuid = itemsCategoryUuid;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
