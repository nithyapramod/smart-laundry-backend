package com.swasth.smartlaundry.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user_types")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserType implements Serializable {

    private static final long serialVersionUID = 3650367688382322303L;

    @Id
    @Column(name = "uuid")
    private String uTuuid;

    @Column(name = "name")
    private String name;

    @Column(name = "user_type")
    private int userType;

    public String getuTuuid() {
        return uTuuid;
    }

    public void setuTuuid(String uTuuid) {
        this.uTuuid = uTuuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }


}
