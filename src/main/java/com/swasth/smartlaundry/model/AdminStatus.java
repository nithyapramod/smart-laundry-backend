package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class AdminStatus implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -2936751555522170517L;

    private String userUuid;
    private int status;

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
