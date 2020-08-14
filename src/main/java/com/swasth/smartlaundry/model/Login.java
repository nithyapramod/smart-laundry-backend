package com.swasth.smartlaundry.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class Login implements Serializable {

    private static final long serialVersionUID = 1L;
    private String phoneNumber;
    private String name;
    private String password;

}
