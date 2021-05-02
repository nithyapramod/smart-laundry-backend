package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class Dashboard implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2936751555522170517L;
    private String fcmKey;
    private String userUuid;

    private int userType;


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

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }


}
