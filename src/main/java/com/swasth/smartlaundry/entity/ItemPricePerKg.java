package com.swasth.smartlaundry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemPricePerKg implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5621356413502709617L;

    @Id
    @Column(name = "uuid")
    private String ipkgUuid;

    @Column(name = "price")
    private Integer price;

    @Column(name = "quantity")
    private Integer quantity;

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

}
