package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class NearBy implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2953784033112354178L;
    private Double lat = 0.0;
    private Double lng = 0.0;

    private Integer type;
    private String fcmKey;
    private String userUuid;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getFcmKey() {
        return fcmKey;
    }

    public void setFcmKey(String fcmKey) {
        this.fcmKey = fcmKey;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

}
