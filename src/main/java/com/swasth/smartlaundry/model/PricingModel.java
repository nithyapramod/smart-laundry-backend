package com.swasth.smartlaundry.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.swasth.smartlaundry.entity.ItemPricing;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PricingModel implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1355308804128926601L;

    /* private List<ItemPricing> itemPricings; */

    private ItemPricing itemPricing;

    public ItemPricing getItemPricing() {
        return itemPricing;
    }

    public void setItemPricing(ItemPricing itemPricing) {
        this.itemPricing = itemPricing;
    }


}
