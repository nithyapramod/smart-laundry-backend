package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class MItemPricingPerKg implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2457975086217809239L;

    private String shopUuid;

    private String itemsCategoryUuid;

    private Integer price;

    private String itemId;

    private Integer quantity;

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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
