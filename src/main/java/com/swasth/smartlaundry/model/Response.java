package com.swasth.smartlaundry.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class Response implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private boolean status;

    private int statusCode;

    private String message;

    private String timeStamp = new Date().toString();

    private String trace;

    private Object payload;

    public Response(boolean status, int statusCode, Map<String, Object> errorAttributes) {
        this.setStatus(status);
        this.setStatusCode(statusCode);
        // this.setPath((String) errorAttributes.get("path"));
        this.setMessage((String) errorAttributes.get("message"));
        this.setTimeStamp(errorAttributes.get("timestamp").toString());
        //this.setTrace((String) errorAttributes.get("trace"));
        this.setPayload(null);
    }

    public Response(boolean status, int statusCode, String message, Object payload) {

        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.payload = payload;
    }

    public static Response createSuccess(boolean status, int statusCode, String message, Object payload) {

        return new Response(status, statusCode, message, payload);
    }

    public static Response createError(boolean status, int statusCode, String message, Object payload) {
        return new Response(status, statusCode, message, payload);
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTrace() {
        return trace;
    }

    public void setTrace(String trace) {
        this.trace = trace;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }


}
