package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "user_order_items")
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamicUpdate(value = true)
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 7335224081960873336L;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "pricing_uuid")
    private String pricingUuid;

    @Column(name = "order_uuid")
    private String orderUuid;

    @Column(name = "item_category_uuid")
    private String itemCategoryUuid;

    @Column(name = "item_category_name")
    private String itemCategoryName;

    @Column(name = "item_uuid")
    private String itemUuid;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "category")
    private String category;

    @Column(name = "item_qty")
    private Integer itemQty;

    @Column(name = "price")
    private Double price;

    @Column(name = "base_price")
    private Double basePrice;

    @JsonIgnore
    @Column(name = "created_on")
    private Date createdOn = new Date();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPricingUuid() {
        return pricingUuid;
    }

    public void setPricingUuid(String pricingUuid) {
        this.pricingUuid = pricingUuid;
    }

    public String getOrderUuid() {
        return orderUuid;
    }

    public void setOrderUuid(String orderUuid) {
        this.orderUuid = orderUuid;
    }

    public String getItemCategoryUuid() {
        return itemCategoryUuid;
    }

    public void setItemCategoryUuid(String itemCategoryUuid) {
        this.itemCategoryUuid = itemCategoryUuid;
    }

    public String getItemCategoryName() {
        return itemCategoryName;
    }

    public void setItemCategoryName(String itemCategoryName) {
        this.itemCategoryName = itemCategoryName;
    }

    public String getItemUuid() {
        return itemUuid;
    }

    public void setItemUuid(String itemUuid) {
        this.itemUuid = itemUuid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getItemQty() {
        return itemQty;
    }

    public void setItemQty(Integer itemQty) {
        this.itemQty = itemQty;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}
