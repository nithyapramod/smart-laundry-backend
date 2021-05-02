package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class VerifyOtp implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 5620268893601385437L;
    private String phoneNumber;
    private String otp;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }


}
