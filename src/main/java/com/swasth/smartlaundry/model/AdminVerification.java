package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class AdminVerification implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 6568623285585403881L;

    private String shopUuid;

    private String adminUuid;

    private int status;

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public String getAdminUuid() {
        return adminUuid;
    }

    public void setAdminUuid(String adminUuid) {
        this.adminUuid = adminUuid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
