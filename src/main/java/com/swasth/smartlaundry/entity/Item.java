package com.swasth.smartlaundry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "items")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Item implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1422564826608555328L;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "item_name")
    private String itemName;

    @JsonIgnore
    @Column(name = "shop_uuid")
    private String shopUuid = "G";

    @Column(name = "unit_type")
    private String unitType;

    @Column(name = "status")
    private String status;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
