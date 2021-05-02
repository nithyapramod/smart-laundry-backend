package com.swasth.smartlaundry.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.swasth.smartlaundry.entity.NearByShops;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NearByShopsDetails implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 9020679092525948229L;

    private List<NearByShops> nearByShops;

    private List<String> bannerImages;

    public List<NearByShops> getNearByShops() {
        return nearByShops;
    }

    public void setNearByShops(List<NearByShops> nearByShops) {
        this.nearByShops = nearByShops;
    }

    public List<String> getBannerImages() {
        return bannerImages;
    }

    public void setBannerImages(List<String> bannerImages) {
        this.bannerImages = bannerImages;
    }

}
