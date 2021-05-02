package com.swasth.smartlaundry.model;

import java.io.Serializable;
import java.util.Date;

public class ShopDataInput implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String shopUuid;
    private Date slotDate;

    public String getShopUuid() {
        return shopUuid;
    }

    public void setShopUuid(String shopUuid) {
        this.shopUuid = shopUuid;
    }

    public Date getSlotDate() {
        return slotDate;
    }

    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
    }

}
