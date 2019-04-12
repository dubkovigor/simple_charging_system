package com.netcracker.edu.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BillingAccountViewModel {

    private Long id;
    private Long number;
    private Long wallerID;

    public BillingAccountViewModel(){}

    public BillingAccountViewModel(Long id, Long number, Long wallerID) {
        this.id = id;
        this.number = number;
        this.wallerID = wallerID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Long getWallerID() {
        return wallerID;
    }

    public void setWallerID(Long wallerID) {
        this.wallerID = wallerID;
    }
}
