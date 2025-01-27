package org.example.psp_spring.model;

import jakarta.persistence.*;

import java.util.Date;

@MappedSuperclass
public abstract class TimeStampedPersistableObject {

    @Column(name = "insert_ts",nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertTimeStamp;

    @Column(name = "update_ts",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTimeStamp;

    @PrePersist
    private void onInsert(){
        this.insertTimeStamp = new Date();
        updateTimeStamp = insertTimeStamp;
    }

    @PreUpdate
    private void onUpdate(){
        this.updateTimeStamp = new Date();
    }



}
