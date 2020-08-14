package com.swasth.smartlaundry.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Response {

    private boolean status;
    private int statusCode;
    private String message;
    private String timeStamp = new Date().toString();
    private Object payload;

    public Response(boolean status, int statusCode, String message, Object payload) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.payload = payload;
    }

}
