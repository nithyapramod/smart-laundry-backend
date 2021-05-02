package com.swasth.smartlaundry.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.swasth.smartlaundry.entity.ItemCategory;
import com.swasth.smartlaundry.entity.TimeSlots;

public class ShopData implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8648102138314350770L;

    private List<TimeSlots> timeSlots;
    private List<ItemCategory> itemCategory = new ArrayList<ItemCategory>();

    public List<TimeSlots> getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(List<TimeSlots> timeSlots) {
        this.timeSlots = timeSlots;
    }

    public List<ItemCategory> getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(List<ItemCategory> itemCategory) {
        this.itemCategory = itemCategory;
    }

}
