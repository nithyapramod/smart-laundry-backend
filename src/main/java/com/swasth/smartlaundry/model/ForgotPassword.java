package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class ForgotPassword implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7889187833658992273L;

    private String phoneNumber;
    private String password;

    private int userType;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

}
