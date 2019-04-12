package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    private Long id;
    private String firstName;
    private String secondName;
    private Long userID;
    private Long ba_Id;

    public Customer() {
    }

    public Customer(Long id, String firstName, String secondName, Long userID, Long ba_Id) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.userID = userID;
        this.ba_Id = ba_Id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Long getBa_Id() {
        return ba_Id;
    }

    public void setBa_Id(Long ba_Id) {
        this.ba_Id = ba_Id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", userID=" + userID +
                ", ba_Id=" + ba_Id +
                '}';
    }
}


