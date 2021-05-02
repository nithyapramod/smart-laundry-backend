package com.swasth.smartlaundry.model;

import java.io.Serializable;

public class ResetPassword implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4217085680366450033L;
    private String phoneNumber;
    private String password;
    private String conformpassword;


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

    public String getConformpassword() {
        return conformpassword;
    }

    public void setConformpassword(String conformpassword) {
        this.conformpassword = conformpassword;
    }

}
