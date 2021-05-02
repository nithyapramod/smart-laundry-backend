package com.swasth.smartlaundry.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "cancel_reason")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelReason implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -8121144512452492570L;

    @Id
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "reason_id")
    private int reasonId;

    @Column(name = "reason_type")
    private int reasonType;

    @Column(name = "reason_name")
    private String reasonName;

    @JsonIgnore
    @Column(name = "status")
    private String status;

    @JsonIgnore
    @Column(name = "created_on")
    private Date createdOn = new Date();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getReasonId() {
        return reasonId;
    }

    public void setReasonId(int reasonId) {
        this.reasonId = reasonId;
    }

    public String getReasonName() {
        return reasonName;
    }

    public void setReasonName(String reasonName) {
        this.reasonName = reasonName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getReasonType() {
        return reasonType;
    }

    public void setReasonType(int reasonType) {
        this.reasonType = reasonType;
    }


}
