package com.swasth.smartlaundry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetItemPricing implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5621356413502709617L;

    @Id
    @Column(name = "item_name")
    private String itemName;

    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "item_category_uuid")
    private String itemsCategoryUuid;

    @Column(name = "item_id")
    private String itemId;

    @Column(name = "price")
    private Integer price;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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


}
