package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatientRecord {
    @Id
    private Integer id;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public PatientRecord() {
    }

    public PatientRecord(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String address;


}