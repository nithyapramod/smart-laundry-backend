package com.swasth.smartlaundry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "time_slots")
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeSlots implements Serializable {

    private static final long serialVersionUID = -9141538878223874268L;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "shop_uuid")
    private String shopUuid;

    @Column(name = "slot")
    private Integer slot;

    @Column(name = "start_at")
    private String startAt;

    @Column(name = "end_at")
    private String endAt;

    @JsonIgnore
    @Column(name = "status")
    private String status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public Integer getSlot() {
        return slot;
    }

    public void setSlot(Integer slot) {
        this.slot = slot;
    }

    public String getStartAt() {
        return startAt;
    }

    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    public String getEndAt() {
        return endAt;
    }

    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
