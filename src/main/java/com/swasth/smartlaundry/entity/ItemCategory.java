package com.swasth.smartlaundry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "item_category")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemCategory implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1422564826608555328L;

    @Id
    @Column(name = "uuid")
    private String icUuid;

    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "image")
    private String image;

    @JsonIgnore
    @Column(name = "status")
    private String status;

    public String getIcUuid() {
        return icUuid;
    }

    public void setIcUuid(String icUuid) {
        this.icUuid = icUuid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

}
