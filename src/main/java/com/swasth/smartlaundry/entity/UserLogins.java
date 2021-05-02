package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "user_logins")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserLogins implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 3022337646819871346L;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "login_time")
    private Date loginTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

}
