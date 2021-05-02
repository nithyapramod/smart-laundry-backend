package com.swasth.smartlaundry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPrice implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5621356413502709617L;

    @Id
    @Column(name = "uuid")
    private String ipmUuid;

    @Column(name = "price")
    private Integer price;

    @Column(name = "item_name")
    private String itemName;

    public String getIpmUuid() {
        return ipmUuid;
    }

    public void setIpmUuid(String ipmUuid) {
        this.ipmUuid = ipmUuid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

}
