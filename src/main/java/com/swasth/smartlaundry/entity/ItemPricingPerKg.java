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
@Table(name = "items_pricing_per_kg")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPricingPerKg implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5621356413502709617L;

    @Id
    @Column(name = "uuid")
    private String ipkgUuid;

    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "category_uuid")
    private String itemsCategoryUuid;

    @Column(name = "price")
    private Integer price;

    @Column(name = "item_id")
    private String itemId;

    @JsonIgnore
    @Column(name = "status")
    private String status = "A";
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "created_on")
    private Date createdOn = new Date();

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIpkgUuid() {
        return ipkgUuid;
    }

    public void setIpkgUuid(String ipkgUuid) {
        this.ipkgUuid = ipkgUuid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

}
